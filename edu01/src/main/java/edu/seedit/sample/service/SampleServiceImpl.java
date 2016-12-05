package edu.seedit.sample.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.seedit.common.dto.UserDTO;
import edu.seedit.common.service.UserService;
import edu.seedit.sample.dao.SampleDAO;
import edu.seedit.sample.vo.BlackVO;
import edu.seedit.sample.vo.SampleVO;

@Service("SampleService")
public class SampleServiceImpl implements SampleService {

	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired UserService userService;

	@Resource(name="SampleDAO")
	private SampleDAO dao;

	@Override
	public List<SampleVO> getSampleList(Map<String,Object> in) throws Exception {
		SampleVO eDTO = new SampleVO();
		if(in.get("userId"        ) != null && !in.get("userId"        ).equals("")) { eDTO.setUserId        (in.get("userId"        ).toString()); }
		if(in.get("userId"        ) != null && !in.get("userId"        ).equals("")) { eDTO.setUserId        (in.get("userId"        ).toString()); }
		if(in.get("corpCode"      ) != null && !in.get("corpCode"      ).equals("")) { eDTO.setCorpCode      (in.get("corpCode"      ).toString()); }
		if(in.get("userName"      ) != null && !in.get("userName"      ).equals("")) { eDTO.setUserName      (in.get("userName"      ).toString()); }
		if(in.get("userPhone"     ) != null && !in.get("userPhone"     ).equals("")) { eDTO.setUserPhone     (in.get("userPhone"     ).toString()); }
		if(in.get("userEmail"     ) != null && !in.get("userEmail"     ).equals("")) { eDTO.setUserEmail     (in.get("userEmail"     ).toString()); }
		if(in.get("userLevel"     ) != null && !in.get("userLevel"     ).equals("")) { eDTO.setUserLevel     (in.get("userLevel"     ).toString()); }
		if(in.get("userDepartment") != null && !in.get("userDepartment").equals("")) { eDTO.setUserDepartment(in.get("userDepartment").toString()); }
		if(in.get("corpName"      ) != null && !in.get("corpName"      ).equals("")) { eDTO.setCorpName      (in.get("corpName"      ).toString()); }
		if(in.get("corpLevel"     ) != null && !in.get("corpLevel"     ).equals("")) { eDTO.setCorpLevel     (in.get("corpLevel"     ).toString()); }
		if(in.get("profileName"   ) != null && !in.get("profileName"   ).equals("")) { eDTO.setProfileName   (in.get("profileName"   ).toString()); }
		if(in.get("departmentName") != null && !in.get("departmentName").equals("")) { eDTO.setDepartmentName(in.get("departmentName").toString()); }
		if(in.get("userRankname"  ) != null && !in.get("userRankname"  ).equals("")) { eDTO.setUserRankname  (in.get("userRankname"  ).toString()); }

		List<SampleVO> out = dao.selectSampleList(eDTO);
		logger.debug("size:" + out.size());
		return out;
		//return null;
	}
	
	@Override
	public SampleVO getSamplelist2(String userId) throws Exception {		
	
		return dao.selectSampleOne(userId);
	}
	
	@Override
	public Object addSample(Map<String,Object> in) throws Exception {

		String result = "FAIL";
		try {
			if(in == null) {
				throw new Exception("NO INPUT");
			}

			UserDTO eDTO = new UserDTO();
			if(in.get("userId"        )!= null && in.get("userId"        ).toString()!="") { eDTO.setUserId        (in.get("userId"        ).toString()); } else throw new Exception("USER_ID is required");
			if(in.get("corpCode"      )!= null && in.get("corpCode"      ).toString()!="") { eDTO.setCorpCode      (in.get("corpCode"      ).toString()); } else throw new Exception("CORP_CODE is required");
			if(in.get("userPw"        )!= null && in.get("userPw"        ).toString()!="") { eDTO.setUserPw        (in.get("userPw"        ).toString()); }
			if(in.get("userName"      )!= null && in.get("userName"      ).toString()!="") { eDTO.setUserName      (in.get("userName"      ).toString()); }
			if(in.get("userPhone"     )!= null && in.get("userPhone"     ).toString()!="") { eDTO.setUserPhone     (in.get("userPhone"     ).toString()); }
			if(in.get("userEmail"     )!= null && in.get("userEmail"     ).toString()!="") { eDTO.setUserEmail     (in.get("userEmail"     ).toString()); }
			if(in.get("userLevel"     )!= null && in.get("userLevel"     ).toString()!="") { eDTO.setUserLevel     (in.get("userLevel"     ).toString()); }
			if(in.get("token"         )!= null && in.get("token"         ).toString()!="") { eDTO.setToken         (in.get("token"         ).toString()); }
			if(in.get("userDepartment")!= null && in.get("userDepartment").toString()!="") { eDTO.setUserDepartment(in.get("userDepartment").toString()); }
			if(in.get("userPushid"    )!= null && in.get("userPushid"    ).toString()!="") { eDTO.setUserPushid    (in.get("userPushid"    ).toString()); }
			if(in.get("userRankcode"  )!= null && in.get("userRankcode"  ).toString()!="") { eDTO.setUserRankcode  (in.get("userRankcode"  ).toString()); }
			if(in.get("userRole"      )!= null && in.get("userRole"      ).toString()!="") { eDTO.setUserRole      (in.get("userRole"      ).toString()); }
			if(in.get("userValue"     )!= null && in.get("userValue"     ).toString()!="") { eDTO.setUserValue     (in.get("userValue"     ).toString()); }
			if(in.get("userStatus"    )!= null && in.get("userStatus"    ).toString()!="") { eDTO.setUserStatus    (in.get("userStatus"    ).toString()); }
			if(in.get("sessionId"     )!= null && in.get("sessionId"     ).toString()!="") { eDTO.setSessionId     (in.get("sessionId"     ).toString()); }
			if(in.get("profileName"   )!= null && in.get("profileName"   ).toString()!="") { eDTO.setProfileName   (in.get("profileName"   ).toString()); }

			logger.debug("eDTO:" + eDTO.toString());

			String tempResult = userService.addUser(eDTO).toString();
			logger.debug("tempResult[" + tempResult + "]");
			int iResult = Integer.getInteger(tempResult);
			logger.debug("iResult[" + iResult + "]");
			if(tempResult !=null && !tempResult.equals("0")) {
				result = "SUCCESS";
			}
		} catch (Exception e) {
			logger.debug("Exception:" + e.getMessage());
			result = e.getMessage();
		}
		return result;
	}

	@Override
	public List<BlackVO> getBlackList() throws Exception {
		List<BlackVO> out = dao.BlackList();
		logger.debug("size:" + out.size());
		return out;
	}

	@Override
	public List<String> getAutoComplete(Map<String, Object> map) throws Exception {

		List<String> list = dao.autoComplete(map);
		logger.debug("Serveice[getSelectIdList] list : " + list);
		return list;
	}

	@Override
	public int getDeleteUser(List<String> arr) throws Exception {
		System.out.println("service :" + arr);
		int count = dao.deleteUser(arr);
		logger.debug("update 데이터된 숫자: " + count);
		return count;
	}

	@Override
	public int getUserIdCheck(String userId) throws Exception {		
		return dao.UserIdCheck(userId);
	}

	@Override
	public Map<String,Object> getUserLoginCheck(String userId) throws Exception {		
		return dao.userLoginCheck(userId);
	}

	@Override
	public List<Map<String, Object>> getSelectBoardList(Map<String, Object> map) {
		
		return dao.selectBoardList(map);
	}

	@Override
	public List<SampleVO> getUserRank(Map<String,Object> requestParam) {
		return	dao.userRank(requestParam);
	}





}
