package com.google.firebase.components;

import java.util.Arrays;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p368l.C4572d;

/* JADX INFO: loaded from: classes3.dex */
public class DependencyCycleException extends DependencyException {
    private final List<C4572d<?>> componentsInCycle;

    /* JADX WARN: Illegal instructions before constructor call */
    public DependencyCycleException(List<C4572d<?>> list) {
        StringBuilder sbM833U = C1643a.m833U("Dependency cycle detected: ");
        sbM833U.append(Arrays.toString(list.toArray()));
        super(sbM833U.toString());
        this.componentsInCycle = list;
    }
}
