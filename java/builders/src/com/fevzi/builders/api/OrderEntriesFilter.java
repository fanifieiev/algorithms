package com.fevzi.builders.api;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import com.fevzi.builders.api.OEFilters.Bulk;
import com.fevzi.builders.api.OEFilters.Filtered;
import com.fevzi.builders.api.OEFilters.Gm;
import com.fevzi.builders.api.OEFilters.HomeDeliverable;
import com.fevzi.builders.api.OEFilters.NotPaid;
import com.fevzi.builders.api.OEFilters.Paid;
import com.fevzi.builders.api.OEFilters.Parameterized;
import com.fevzi.builders.api.OEFilters.Parceled;
import com.fevzi.builders.api.OEFilters.PayAndPickupable;
import com.fevzi.builders.api.OEFilters.Ror;
import com.fevzi.builders.api.OEFilters.Sord;
import com.fevzi.builders.model.AbstractOrderEntryModel;
import com.fevzi.builders.model.CtcDeliveryMode;
import com.fevzi.builders.model.CtcOrderLineStatus;
import com.fevzi.builders.model.EmployeeAssignment;
import com.fevzi.builders.model.EmployeeModel;
import com.fevzi.builders.model.ProductAccessByRole;

public final class OrderEntriesFilter implements Filtered, Parameterized, HomeDeliverable, PayAndPickupable, Ror, Gm,
        Sord, Bulk, Parceled, Paid, NotPaid {


    @Override
    public <F extends Filtered & Parameterized & Paid & NotPaid> F deliveryToHome() {
        return null;
    }

    @Override
    public <F extends Filtered & Parameterized & Paid & NotPaid> F payAndPickup() {
        return null;
    }

    @Override
    public <F extends Filtered & Parameterized & Paid & NotPaid> F rorOnly() {
        return null;
    }

    @Override
    public <F extends Filtered & Parameterized & Paid & NotPaid> F gmOnly() {
        return null;
    }

    @Override
    public <F extends Filtered & Parameterized & Paid & NotPaid> F bulkOnly() {
        return null;
    }

    @Override
    public <F extends Filtered & Parameterized & Paid & NotPaid> F parcelOnly() {
        return null;
    }

    @Override
    public <F extends Filtered & Parameterized> F withPosTransactionId(final String posTransactionId) {
        return null;
    }

    @Override
    public <F extends Filtered & Parameterized> F withoutPosTransactionId() {
        return null;
    }

    @Override
    public <F extends Filtered & Parameterized> F livingOnly() {
        return null;
    }

    @Override
    public <F extends Filtered & Parameterized> F withEntryNumbers(final Collection<Integer> entryNumbers) {
        return null;
    }

    @Override
    public <F extends Filtered & Parameterized> F withSkuCodes(final Collection<String> skuCodes) {
        return null;
    }

    @Override
    public <F extends Filtered & Parameterized> F withStatuses(final Collection<CtcOrderLineStatus> statuses) {
        return null;
    }

    @Override
    public <F extends Filtered & Parameterized> F withDeliveryMode(final CtcDeliveryMode deliveryMode) {
        return null;
    }

    @Override
    public <F extends Filtered & Parameterized> F withAssignmentsForEmployee(
            final Collection<EmployeeAssignment> assignments, final EmployeeModel currentEmployee) {
        return null;
    }

    @Override
    public <F extends Filtered & Parameterized> F withProductAccessByRole(
            final ProductAccessByRole productAccessByRole) {
        return null;
    }

    @Override
    public <T extends AbstractOrderEntryModel> List<T> filter(final Collection<T> entries) {
        return null;
    }

    @Override
    public <T extends AbstractOrderEntryModel> T getFirst(final Collection<T> entries) {
        return null;
    }

    @Override
    public <T extends AbstractOrderEntryModel> Stream<T> filteredStream(final Collection<T> entries) {
        return null;
    }

    @Override
    public <T extends AbstractOrderEntryModel> boolean existsIn(final Collection<T> entries) {
        return false;
    }

    @Override
    public <F extends Filtered & Parameterized & Paid & NotPaid> F sordOnly() {
        return null;
    }
}
