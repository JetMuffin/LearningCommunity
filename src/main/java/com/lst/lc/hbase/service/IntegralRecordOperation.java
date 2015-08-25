package com.lst.lc.hbase.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lst.lc.dao.OperationDao;
import com.lst.lc.hbase.model.IntegralRecord;
import com.lst.lc.utils.DateUtils;

@Service
public class IntegralRecordOperation {

        @Autowired
        private HbaseOperation mHbaseOperation;
        @Autowired
        private ModelMapping modelMapping;
        
        @Autowired
        @Qualifier("operationDao")
        private OperationDao operationDao;

        public void add(IntegralRecord integralRecord) {
                if ((integralRecord == null)
                                || (integralRecord.getKey().equals(""))) {
                        // 传值有问题，处理一下
                        return;
                }
                mHbaseOperation.insertData("lc_integralRecord",
                                integralRecord.getKey(), "attr", "date",
                                integralRecord.getDate());
                mHbaseOperation.insertData("lc_integralRecord",
                                integralRecord.getKey(), "var", "integral",
                                integralRecord.getIntegral());
        }

        public IntegralRecord get(String key) {
                Result rs = mHbaseOperation.queryByRowKey("lc_integralRecord",
                                key);
                return modelMapping.integralRecordMapping(rs, key);
        }

        public List<IntegralRecord> getRecent(String email) {
                ResultScanner rs = mHbaseOperation.queryIntegral(email);
                List<IntegralRecord> lists =  modelMapping.integralListMapping(rs);
                IntegralRecord record = get(email+DateUtils.getCurrentDate());
                if(lists == null){
                        lists = new ArrayList<IntegralRecord>();
                }
                lists.add(record);
                return lists;
        }

        public void update(String email, String operation ) {
                int integral = operationDao.getIntegral(operation);
                String key = email + DateUtils.getCurrentDate();
                IntegralRecord record = get(key);
                IntegralRecord todayRecord = null;
                if (record == null) {
                        todayRecord = new IntegralRecord(email,
                                        String.valueOf(integral));
                        add(todayRecord);
                } else {
                        int add;
                        if(record.getIntegral() == null || record
                                        .getIntegral().equals("")){
                                add = 0;
                        }else{
                                add = Integer.parseInt(record.getIntegral());
                        }
                        todayRecord = new IntegralRecord(
                                        email,
                                        String.valueOf(integral + add));
                }
        }
}
