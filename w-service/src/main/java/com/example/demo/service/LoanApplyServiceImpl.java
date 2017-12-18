package com.example.demo.service;
import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.api.entity.LoanApply;
import com.example.demo.api.service.LoanApplyService;
import com.example.demo.mapper.LoanApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Transactional
@Service(version = "1.0.0")
public class LoanApplyServiceImpl implements LoanApplyService {

	@Autowired
	private LoanApplyMapper loanApplyMapper;
	@Override
	public List<LoanApply> loanApplyList() {
		/*LoanApply loanApply = new LoanApply();
		List<LoanApply> loanApplyList = loanApply.selectList(new EntityWrapper<LoanApply>().eq("is_delete",1).eq("apply_status","apply_success"));*/
		List<LoanApply> loanApplyList = loanApplyMapper.selectApplyList();
		return loanApplyList;
 	}
}
