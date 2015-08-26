package com.lst.lc.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.lst.lc.dao.BlogDao;
import com.lst.lc.entities.Blog;
import com.lst.lc.entities.Question;
import com.lst.lc.utils.DateUtils;

/**
 * @author innerac
 *
 */
@Repository("blogDao")
public class BlogDaoImpl extends BaseDao implements BlogDao {

	@Override
	public void addBlog(Blog blog) {
		save(blog);
	}

	@Override
	public void updateBlog(Blog blog) {
		update(blog);
	}

	@Override
	public Blog getBlog(int blogId) {
		return get(Blog.class, blogId);
	}

	@Override
	public void deleteBlog(int blogId) {
		String hql = "delete Blog as blog where blog.blogId = ?";
		Query query = query(hql);
		query.setInteger(0, blogId);
		query.executeUpdate();
	}

	@Override
	public List<Blog> getBlogsOfUser(int userId) {
		String hql = "from Blog as blog where blog.user.userId = ? order by blog.time desc";
		Query query = query(hql);
		query.setInteger(0, userId);
		return query.list();
	}

	@Override
	public List<Blog> getTopFiveRecently() {
		Date end = DateUtils.getDateBefore(new Date(), 7);
		String hql = "from Blog as blog where blog.time > ? order by blog.readNums*0.2+blog.answerNums*0.8 desc";
		Query query = query(hql);
		query.setDate(0, end);
		query.setMaxResults(5);
		List<Blog> lists = query.list();
		return lists;
	}

	@Override
	public void addReadNums(int blogId) {
		String hql = "update Blog as blog set blog.readNums = blog.readNums + 1 where blog.blogId = ?";
		Query query = query(hql).setInteger(0, blogId);
		query.executeUpdate();
	}

	@Override
	public List<Blog> getOtherBlogs(int userId, int blogId) {
		String hql = "from Blog as blog where blog.user.userId = ? and blog.blogId <> ?";
		Query query = query(hql).setInteger(0, userId).setInteger(1, blogId).setMaxResults(5);
		return query.list();
	}

	@Override
	public List<Blog> search(String key) {
		String hql = "from Blog as blog where blog.title like ?";
		Query query = query(hql).setString(0, "%" + key + "%");
		return query.list();
	}

        @Override
        public void addCommentNums(int blogId) {
                String hql = "update Blog as blog set blog.commentNums = blog.commentNums + 1 where blog.blogId = ?";
                Query query = query(hql).setInteger(0, blogId);
                query.executeUpdate();
        }

        @Override
        public long count() {
                String hql = "select count(*) from Blog";
                Query query = query(hql);
                long res = (long) query.uniqueResult();
                return res;
        }

        @Override
        public long userCount() {
                String hql = "select count(DISTINCT blog.user) from Blog as blog";
                Query query = query(hql);
                long res = (long) query.uniqueResult();
                return res;
        }

}
