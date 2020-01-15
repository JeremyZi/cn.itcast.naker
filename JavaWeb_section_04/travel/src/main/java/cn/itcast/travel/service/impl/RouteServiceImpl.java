package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {

	private RouteDao dao = new RouteDaoImpl();

	@Override
	public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname) {

		//封装PageBean
		PageBean<Route> pb = new PageBean<>();

		//设置当前页码
		pb.setCurrentPage(currentPage);

		//设置每页显示条数
		pb.setPageSize(pageSize);

		//设置总记录数
		int totalCount = dao.findTotalCount(cid, rname);
		pb.setTotalCount(totalCount);

		//设置当前页显示的数据集合
		int start = (currentPage - 1) * pageSize; //开始的记录数
		List<Route> list = dao.findByPage(cid, start, pageSize, rname);
		pb.setList(list);

		//设置总页数
		int totalPage = totalCount % pageSize == 0 ? (totalCount / pageSize) : ((totalCount / pageSize) + 1);
		pb.setTotalPage(totalPage);
		return pb;
	}

}
