package com.tscm.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tscm.db.SqlSessionManager;

public class BmtDAO {
	private static final Logger LOG = LoggerFactory.getLogger(BmtUserDAO.class); 
	private SqlSessionFactory factory =  SqlSessionManager.getFactory();
	
	public List<BmtPtDetailDTO> selectAllPost() {
		List<BmtPtDetailDTO> listDto = null;

		LOG.debug("selectAllPost start ");
		
		SqlSession session = factory.openSession(true);
		try {
			listDto = session.selectList("bmt_selectAllPost");
			if (listDto != null) {
//				for(int i=0; i< listDto.size(); i++)
				for(int i=0; i< 2; i++)
				{
					LOG.debug("bmt_selectAllPost - {} : {} - {} ", 
							i, listDto.get(i).getU_name(), listDto.get(i).getP_content() );
				}
			} else {
				LOG.debug("bmt_selectAllPost fail");
			}
			
		} finally {
			session.close();
		}
		
		return listDto;
	}
	
	

}
