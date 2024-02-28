package com.company.onlinecustomerservicecenter.operator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.company.onlinecustomerservicecenter.issue.Issue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OperatorController {
    @Autowired
    private OperatorService operatorService;
    @PostMapping("create/operator/{deptId}")
    public Operator createOperator(@RequestBody Operator operator,@PathVariable("deptId")Integer id) throws OperatorException {
        return this.operatorService.createAnOperator(operator,id);
    }
    @PostMapping("add/issues")
    public Issue addIssue(@RequestBody Issue issue)
    {
        return this.operatorService.addIssue(issue);
    }
    @PutMapping("assign/issue/{operatorId}/{issueId}")
    public Operator assignIssueToOperator(@PathVariable("operatorId")Integer operatorId,@PathVariable("issueId") Integer issueId) throws OperatorException {
        return this.operatorService.assignIssue(operatorId,issueId);
    }
    @GetMapping("operator/all")
    public List<Operator> getAllOperator() {
        return this.operatorService.getAllOperator();
    }
    @GetMapping("issues/all")
    public  List<Issue> getAllIssues()
    {
        return this.operatorService.getAllIssues();
    }
    @PutMapping("issueSolved/inCart/{operatorId}/{issueId}")
    public Operator issueSolved(@PathVariable("operatorId") Integer operatorId,@PathVariable("issueId") Integer issueId) throws OperatorException {
        return this.operatorService.issueSolved(operatorId,issueId);
    }
    @DeleteMapping("deleteOperator/{id}")
    public Boolean deleteOperator(@PathVariable("id") Integer id) throws OperatorException {
        return this.operatorService.deleteOperator(id);
    }
    @GetMapping("remainingIssue/{operatorId}")
    public Integer remainingIssuesByOPerator(@PathVariable("operatorId")Integer operatorId) throws OperatorException {
        return this.operatorService.remainingIssuesByOperator(operatorId);
    }
    @GetMapping("getOperatorsById/{deptId}")
    public List<Operator> getOperatorById(@PathVariable("deptId") Integer id) throws OperatorException {
        return this.operatorService.getAllOperatorsByDept(id);
    }

}

