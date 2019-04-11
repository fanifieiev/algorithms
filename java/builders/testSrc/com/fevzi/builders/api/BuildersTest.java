package com.fevzi.builders.api;

import java.util.Collections;

import org.junit.Test;

import com.fevzi.builders.model.CtcOrderLineStatus;

public class BuildersTest {

    @Test
    void shouldBuild() {
        final OrderEntriesFilter filter = new OrderEntriesFilter()
                .deliveryToHome()
                .withoutPosTransactionId()
                .livingOnly()
                .withSkuCodes(null)
                .withStatuses(Collections.singleton(new CtcOrderLineStatus()));
    }
}
