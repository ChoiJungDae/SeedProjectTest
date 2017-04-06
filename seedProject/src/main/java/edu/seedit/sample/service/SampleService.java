package edu.seedit.sample.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.seedit.sample.vo.BlackVO;
import edu.seedit.sample.vo.SampleVO;

public interface SampleService {

	List<SampleVO> getSampleList(Map<String,Object> in) throws Exception;
	
	SampleVO getSamplelist2(String userId) throws Exception;

	Object addSample(Map<String,Object> in) throws Exception;
	
	List<BlackVO> getBlackList() throws Exception;
	
	List<String> getAutoComplete(Map<String, Object> map) throws Exception;
	
	int getDeleteUser(List<String> arr)  throws Exception;

	int getUserIdCheck(String userId) throws Exception;

	Map<String,Object> getUserLoginCheck(String userId)  throws Exception;

	List<Map<String, Object>> getSelectBoardList(Map<String, Object> map);

	List<SampleVO> getUserRank(Map<String,Object> requestParam);

}
