package com.alibaba.alink.batchoperator.sql;

import java.util.List;

import com.alibaba.alink.batchoperator.BatchOperator;

public class MinusAllBatchOp extends BatchOperator {

    public MinusAllBatchOp() {
        super(null);
    }

    @Override
    public BatchOperator linkFrom(BatchOperator op) {
        throw new RuntimeException("Need 2 inputs.");
    }

    @Override
    public BatchOperator linkFrom(List <BatchOperator> ins) {
        if (ins == null || ins.size() != 2) {
            throw new RuntimeException("Need 2 inputs.");
        }
        this.table = ins.get(0).getTable().minusAll(ins.get(1).getTable());
        return this;
    }
}
