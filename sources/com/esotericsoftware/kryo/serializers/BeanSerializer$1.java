package com.esotericsoftware.kryo.serializers;

import java.beans.PropertyDescriptor;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class BeanSerializer$1 implements Comparator<PropertyDescriptor> {
    public final /* synthetic */ BeanSerializer this$0;

    public BeanSerializer$1(BeanSerializer beanSerializer) {
        this.this$0 = beanSerializer;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(PropertyDescriptor propertyDescriptor, PropertyDescriptor propertyDescriptor2) {
        return compare2(propertyDescriptor, propertyDescriptor2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(PropertyDescriptor propertyDescriptor, PropertyDescriptor propertyDescriptor2) {
        return propertyDescriptor.getName().compareTo(propertyDescriptor2.getName());
    }
}
