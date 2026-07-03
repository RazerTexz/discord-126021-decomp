package com.esotericsoftware.kryo.serializers;

import java.util.Iterator;
import java.util.LinkedList;
import p007b.p106e.p107a.C1644a;

/* JADX INFO: loaded from: classes.dex */
public final class GenericsResolver {
    private LinkedList<Generics> stack = new LinkedList<>();

    public Class getConcreteClass(String str) {
        Iterator<Generics> it = this.stack.iterator();
        while (it.hasNext()) {
            Class concreteClass = it.next().getConcreteClass(str);
            if (concreteClass != null) {
                return concreteClass;
            }
        }
        return null;
    }

    public boolean isSet() {
        return !this.stack.isEmpty();
    }

    public void popScope() {
        this.stack.removeFirst();
    }

    public void pushScope(Class cls, Generics generics) {
        C1644a.a aVar = C1644a.f3007a;
        this.stack.addFirst(generics);
    }
}
