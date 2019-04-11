package com.fevzi.builders.api;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import com.fevzi.builders.model.AbstractOrderEntryModel;
import com.fevzi.builders.model.CtcDeliveryMode;
import com.fevzi.builders.model.CtcOrderLineStatus;
import com.fevzi.builders.model.EmployeeAssignment;
import com.fevzi.builders.model.EmployeeModel;
import com.fevzi.builders.model.ProductAccessByRole;

public interface OEFilters {

    interface HomeDeliverable {
        <F extends Filtered & Parameterized & Paid & NotPaid> F deliveryToHome();
    }

    interface PayAndPickupable {
        <F extends Filtered & Parameterized & Paid & NotPaid> F payAndPickup();
    }

    interface Ror {
        <F extends Filtered & Parameterized & Paid & NotPaid> F rorOnly();
    }

    interface Gm {
        <F extends Filtered & Parameterized & Paid & NotPaid> F gmOnly();
    }

    interface Sord {
        <F extends Filtered & Parameterized & Paid & NotPaid> F sordOnly();
    }

    interface Bulk {
        <F extends Filtered & Parameterized & Paid & NotPaid> F bulkOnly();
    }

    interface Parceled {
        <F extends Filtered & Parameterized & Paid & NotPaid> F parcelOnly();
    }

    interface Paid {
        <F extends Filtered & Parameterized> F withPosTransactionId(String posTransactionId);
    }

    interface NotPaid {
        <F extends Filtered & Parameterized> F withoutPosTransactionId();
    }

    interface Parameterized {
        <F extends Filtered & Parameterized> F livingOnly();

        <F extends Filtered & Parameterized> F withEntryNumbers(Collection<Integer> entryNumbers);

        <F extends Filtered & Parameterized> F withSkuCodes(Collection<String> skuCodes);

        <F extends Filtered & Parameterized> F withStatuses(Collection<CtcOrderLineStatus> statuses);

        <F extends Filtered & Parameterized> F withDeliveryMode(CtcDeliveryMode deliveryMode);

        <F extends Filtered & Parameterized> F withAssignmentsForEmployee(Collection<EmployeeAssignment> assignments,
                EmployeeModel currentEmployee);

        <F extends Filtered & Parameterized> F withProductAccessByRole(ProductAccessByRole productAccessByRole);
    }

    interface Filtered {
        <T extends AbstractOrderEntryModel> List<T> filter(Collection<T> entries);

        <T extends AbstractOrderEntryModel> T getFirst(Collection<T> entries);

        <T extends AbstractOrderEntryModel> Stream<T> filteredStream(Collection<T> entries);

        <T extends AbstractOrderEntryModel> boolean existsIn(Collection<T> entries);
    }
}
