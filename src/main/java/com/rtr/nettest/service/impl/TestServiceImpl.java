package com.rtr.nettest.service.impl;

import com.rtr.nettest.constant.Constants;
import com.rtr.nettest.model.Test;
import com.rtr.nettest.repository.TestRepository;
import com.rtr.nettest.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    @Override
    public Test save(Test test) {
        return testRepository.save(test);
    }

    @Override
    public String getRmbtSetProviderFromAs(Long testUid) {
        return testRepository.getRmbtSetProviderFromAs(testUid);
    }

    @Override
    public Integer getRmbtNextTestSlot(Long testUid) {
        return testRepository.getRmbtNextTestSlot(testUid);
    }

    @Override
    public List<String> getDeviceHistory(Long clientId) {
        var resultList = testRepository.getDistinctModelByClientId(clientId);
        resultList.replaceAll(t -> Objects.isNull(t) ? Constants.UNKNOWN_DEVICE : t);
        return resultList;
    }

    @Override
    public List<String> getGroupNameByClientId(Long clientId) {
        return testRepository.getDistinctGroupNameByClientId(clientId);
    }
}
