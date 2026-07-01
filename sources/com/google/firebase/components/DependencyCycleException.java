package com.google.firebase.components;

import b.d.b.a.outline;
import b.i.c.l.Component4;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DependencyCycleException extends DependencyException {
    private final List<Component4<?>> componentsInCycle;

    /* JADX WARN: Illegal instructions before constructor call */
    public DependencyCycleException(List<Component4<?>> list) {
        StringBuilder sbU = outline.U("Dependency cycle detected: ");
        sbU.append(Arrays.toString(list.toArray()));
        super(sbU.toString());
        this.componentsInCycle = list;
    }
}
