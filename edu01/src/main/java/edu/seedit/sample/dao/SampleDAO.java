package edu.seedit.sample.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import edu.seedit.common.dao.AbstractDAO;
import edu.seedit.sample.vo.BlackVO;
import edu.seedit.sample.vo.SampleVO;

@Repository("SampleDAO")
public class SampleDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<SampleVO> selectSampleList(SampleVO in) throws Exception {
		return (List<SampleVO>) list("selectSampleList", in);
		// return null;
	}

	@SuppressWarnings("unchecked")
	public SampleVO selectSampleOne(String userId) throws Exception {
		return SampleVO_one("selectSampleOne", userId);
		// return null;
	}

	@SuppressWarnings("unchecked")
	public List<BlackVO> BlackList() throws Exception {
		return (List<BlackVO>) list("BlackList");
		// return null;
	}

	@SuppressWarnings("unchecked")
	public List<String> autoComplete(Map<String, Object> map) throws Exception {
		int select = Integer.parseInt((String) map.get("key"));
		switch (select) {
		case 001:
			map.put("key", "user_id");
			break;
		case 002:
			map.put("key", "user_phone");
			break;
		case 003:
			map.put("key", "user_email");
			break;
		}
		List<SampleVO> list = (List<SampleVO>) list("selectIdList", map);

		List<String> strList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			switch (select) {
			case 001:
				strList.add(list.get(i).getUserId());
				break;
			case 002:
				strList.add(list.get(i).getUserPhone());
				break;
			case 003:
				strList.add(list.get(i).getUserEmail());
				break;
			}
		}
		return strList;
	}

	public int deleteUser(List<String> arr) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", arr);
		System.out.println("list : " + arr);
		return update("deleteList", arr);
	}

	public int UserIdCheck(String userId) {
		return count("UserIdCheck", userId);
	}

	public Map<String, Object> userLoginCheck(String userId) {
		return Map_one("userLoginCheck", userId);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {
		System.out.println("넘어온 값 : "+ map);
		return (List<Map<String, Object>>) selectPagingList("sample.selectBoardList", map);
	}

	@SuppressWarnings("unchecked")
	public List<SampleVO> userRank(Map<String,Object> requestParam) {
		return (List<SampleVO>)list("userRank",requestParam);
	}

}
