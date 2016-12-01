package edu.seedit.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import edu.seedit.sample.vo.SampleVO;

public class AbstractDAO {

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private SqlSessionTemplate sqlSession;

	protected void printQueryId(String queryId) {
		if (logger.isDebugEnabled()) {
			logger.debug("\t QueryId \t: " + queryId);
		}
	}

	protected void printQueryId(String queryId, Object params) {
		if (logger.isDebugEnabled()) {
			logger.debug("\t Query \t: " + params.toString());
		}
	}

	public int insert(String queryId, Object params) {
		printQueryId(queryId);
		return sqlSession.insert(queryId, params);
	}

	public int update(String queryId, Object params) {
		printQueryId(queryId);
		return sqlSession.update(queryId, params);
	}

	public int delete(String queryId, Object params) {
		printQueryId(queryId);
		return sqlSession.delete(queryId, params);
	}

	public Object select(String queryId) {
		printQueryId(queryId);
		return sqlSession.selectOne(queryId);
	}

	public Object select(String queryId, Object params) {
		printQueryId(queryId);
		return sqlSession.selectOne(queryId, params);
	}

	@SuppressWarnings("rawtypes")
	public List list(String queryId) {
		printQueryId(queryId);
		return sqlSession.selectList(queryId);
	}

	@SuppressWarnings("rawtypes")
	public List list(String queryId, Object params) {
		printQueryId(queryId);
		return sqlSession.selectList(queryId, params);
	}

	@SuppressWarnings("rawtypes")
	public SampleVO SampleVO_one(String queryId, Object params) {
		printQueryId(queryId);
		System.out.println(queryId + ", " + params);
		return sqlSession.selectOne(queryId, params);
	}

	@SuppressWarnings("rawtypes")
	public int count(String queryId, Object params) {
		printQueryId(queryId);
		System.out.println(queryId + ", " + params);
		return sqlSession.selectOne(queryId, params);
	}

	@SuppressWarnings("rawtypes")
	public Map<String, Object> Map_one(String queryId, Object params) {
		printQueryId(queryId);
		System.out.println(queryId + ", " + params);
		return sqlSession.selectOne(queryId, params);
	}

	@SuppressWarnings("unchecked")
	public Object selectPagingList(String queryId, Object params) {
		printQueryId(queryId);
		Map<String, Object> map = (Map<String, Object>) params;

		String strPageIndex = (String) map.get("PAGE_INDEX");
		String strPageRow = (String) map.get("PAGE_ROW");
		int nPageIndex = 0;
		int nPageRow = 10;

		if (StringUtils.isEmpty(strPageIndex) == false) {
			nPageIndex = Integer.parseInt(strPageIndex) - 1;
		}
		if (StringUtils.isEmpty(strPageRow) == false) {
			nPageRow = Integer.parseInt(strPageRow);
		}
		map.put("START", (nPageIndex * nPageRow) + 1);
		map.put("END", (nPageIndex * nPageRow) + nPageRow);

		return sqlSession.selectList(queryId, map);
	}

}
