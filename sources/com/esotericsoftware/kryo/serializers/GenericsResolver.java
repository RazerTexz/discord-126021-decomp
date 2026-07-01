package com.esotericsoftware.kryo.serializers;

import b.e.a.a;
import b.e.a.a$a;
import java.util.Iterator;
import java.util.LinkedList;

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
        a$a a_a = a.a;
        this.stack.addFirst(generics);
    }
}
