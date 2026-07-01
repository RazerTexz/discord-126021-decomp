package com.google.firebase.components;

import b.d.b.a.a;
import b.i.c.l.d;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DependencyCycleException extends DependencyException {
    private final List<d<?>> componentsInCycle;

    /* JADX WARN: Illegal instructions before constructor call */
    public DependencyCycleException(List<d<?>> list) {
        StringBuilder sbU = a.U("Dependency cycle detected: ");
        sbU.append(Arrays.toString(list.toArray()));
        super(sbU.toString());
        this.componentsInCycle = list;
    }
}
