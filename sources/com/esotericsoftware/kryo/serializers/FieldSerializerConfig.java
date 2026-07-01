package com.esotericsoftware.kryo.serializers;

import b.e.a.Log;
import com.esotericsoftware.kryo.serializers.FieldSerializer;

/* JADX INFO: loaded from: classes.dex */
public class FieldSerializerConfig implements Cloneable {
    private boolean fixedFieldTypes;
    private boolean fieldsCanBeNull = true;
    private boolean setFieldsAsAccessible = true;
    private boolean ignoreSyntheticFields = true;
    private boolean copyTransient = true;
    private boolean serializeTransient = false;
    private boolean optimizedGenerics = false;
    private FieldSerializer.CachedFieldNameStrategy cachedFieldNameStrategy = FieldSerializer.CachedFieldNameStrategy.DEFAULT;
    private boolean useAsm = true ^ FieldSerializer.unsafeAvailable;

    public FieldSerializerConfig() {
        Log.a aVar = Log.a;
    }

    public FieldSerializer.CachedFieldNameStrategy getCachedFieldNameStrategy() {
        return this.cachedFieldNameStrategy;
    }

    public boolean isCopyTransient() {
        return this.copyTransient;
    }

    public boolean isFieldsCanBeNull() {
        return this.fieldsCanBeNull;
    }

    public boolean isFixedFieldTypes() {
        return this.fixedFieldTypes;
    }

    public boolean isIgnoreSyntheticFields() {
        return this.ignoreSyntheticFields;
    }

    public boolean isOptimizedGenerics() {
        return this.optimizedGenerics;
    }

    public boolean isSerializeTransient() {
        return this.serializeTransient;
    }

    public boolean isSetFieldsAsAccessible() {
        return this.setFieldsAsAccessible;
    }

    public boolean isUseAsm() {
        return this.useAsm;
    }

    public void setCachedFieldNameStrategy(FieldSerializer.CachedFieldNameStrategy cachedFieldNameStrategy) {
        this.cachedFieldNameStrategy = cachedFieldNameStrategy;
        Log.a aVar = Log.a;
    }

    public void setCopyTransient(boolean z2) {
        this.copyTransient = z2;
    }

    public void setFieldsAsAccessible(boolean z2) {
        this.setFieldsAsAccessible = z2;
        Log.a aVar = Log.a;
    }

    public void setFieldsCanBeNull(boolean z2) {
        this.fieldsCanBeNull = z2;
        Log.a aVar = Log.a;
    }

    public void setFixedFieldTypes(boolean z2) {
        this.fixedFieldTypes = z2;
        Log.a aVar = Log.a;
    }

    public void setIgnoreSyntheticFields(boolean z2) {
        this.ignoreSyntheticFields = z2;
        Log.a aVar = Log.a;
    }

    public void setOptimizedGenerics(boolean z2) {
        this.optimizedGenerics = z2;
        Log.a aVar = Log.a;
    }

    public void setSerializeTransient(boolean z2) {
        this.serializeTransient = z2;
    }

    public void setUseAsm(boolean z2) {
        this.useAsm = z2;
        if (!z2 && !FieldSerializer.unsafeAvailable) {
            this.useAsm = true;
            Log.a aVar = Log.a;
        }
        Log.a aVar2 = Log.a;
    }

    @Override // 
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public FieldSerializerConfig mo77clone() {
        try {
            return (FieldSerializerConfig) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
