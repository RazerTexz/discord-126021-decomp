package com.esotericsoftware.kryo.serializers;

import b.e.a.a;
import b.e.a.a$a;
import b.e.b.c;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.NotNull;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.IntArray;
import com.esotericsoftware.kryo.util.ObjectMap;
import com.esotericsoftware.kryo.util.Util;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FieldSerializer<T> extends Serializer<T> implements Comparator<FieldSerializer$CachedField> {
    public static FieldSerializer$CachedFieldFactory asmFieldFactory;
    public static FieldSerializer$CachedFieldFactory objectFieldFactory;
    public static Method sortFieldsByOffsetMethod;
    public static boolean unsafeAvailable;
    public static FieldSerializer$CachedFieldFactory unsafeFieldFactory;
    public static Class<?> unsafeUtilClass;
    public Object access;
    private FieldSerializerAnnotationsUtil annotationsUtil;
    public final Class componentType;
    public final FieldSerializerConfig config;
    private FieldSerializer$CachedField[] fields;
    private Class[] generics;
    private Generics genericsScope;
    private FieldSerializerGenericsUtil genericsUtil;
    private boolean hasObjectFields;
    public final Kryo kryo;
    public HashSet<FieldSerializer$CachedField> removedFields;
    private FieldSerializer$CachedField[] transientFields;
    public final Class type;
    public final TypeVariable[] typeParameters;
    private FieldSerializerUnsafeUtil unsafeUtil;
    private boolean useMemRegions;
    private boolean varIntsEnabled;

    static {
        try {
            Class<?> clsLoadClass = FieldSerializer.class.getClassLoader().loadClass("com.esotericsoftware.kryo.util.UnsafeUtil");
            unsafeUtilClass = clsLoadClass;
            Method method = clsLoadClass.getMethod("unsafe", new Class[0]);
            sortFieldsByOffsetMethod = unsafeUtilClass.getMethod("sortFieldsByOffset", List.class);
            if (method.invoke(null, new Object[0]) != null) {
                unsafeAvailable = true;
            }
        } catch (Throwable unused) {
            a$a a_a = a.a;
        }
    }

    public FieldSerializer(Kryo kryo, Class cls) {
        this(kryo, cls, null);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0060  */
    /* JADX WARN: Code duplicated, block: B:28:0x0069  */
    /* JADX WARN: Code duplicated, block: B:33:0x007e  */
    private List<Field> buildValidFields(boolean z2, List<Field> list, ObjectMap objectMap, IntArray intArray) {
        FieldSerializer$Optional fieldSerializer$Optional;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Field field = list.get(i);
            int modifiers = field.getModifiers();
            if (Modifier.isTransient(modifiers) == z2 && !Modifier.isStatic(modifiers) && (!field.isSynthetic() || !this.config.isIgnoreSyntheticFields())) {
                if (field.isAccessible()) {
                    fieldSerializer$Optional = (FieldSerializer$Optional) field.getAnnotation(FieldSerializer$Optional.class);
                    if (fieldSerializer$Optional != null || objectMap.containsKey(fieldSerializer$Optional.value())) {
                        arrayList.add(field);
                        intArray.add((Modifier.isFinal(modifiers) && Modifier.isPublic(modifiers) && Modifier.isPublic(field.getType().getModifiers())) ? 1 : 0);
                    }
                } else if (this.config.isSetFieldsAsAccessible()) {
                    try {
                        field.setAccessible(true);
                        fieldSerializer$Optional = (FieldSerializer$Optional) field.getAnnotation(FieldSerializer$Optional.class);
                        if (fieldSerializer$Optional != null) {
                            arrayList.add(field);
                            intArray.add((Modifier.isFinal(modifiers) && Modifier.isPublic(modifiers) && Modifier.isPublic(field.getType().getModifiers())) ? 1 : 0);
                        } else {
                            arrayList.add(field);
                            intArray.add((Modifier.isFinal(modifiers) && Modifier.isPublic(modifiers) && Modifier.isPublic(field.getType().getModifiers())) ? 1 : 0);
                        }
                    } catch (AccessControlException unused) {
                    }
                }
            }
        }
        return arrayList;
    }

    private List<Field> buildValidFieldsFromCachedFields(FieldSerializer$CachedField[] fieldSerializer$CachedFieldArr, IntArray intArray) {
        ArrayList arrayList = new ArrayList(fieldSerializer$CachedFieldArr.length);
        for (FieldSerializer$CachedField fieldSerializer$CachedField : fieldSerializer$CachedFieldArr) {
            arrayList.add(fieldSerializer$CachedField.field);
            intArray.add(fieldSerializer$CachedField.accessIndex > -1 ? 1 : 0);
        }
        return arrayList;
    }

    private void createCachedFields(IntArray intArray, List<Field> list, List<FieldSerializer$CachedField> list2, int i) {
        if (!this.config.isUseAsm() && this.useMemRegions) {
            this.unsafeUtil.createUnsafeCacheFieldsAndRegions(list, list2, i, intArray);
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Field field = list.get(i2);
            int iH = -1;
            if (this.access != null && intArray.get(i + i2) == 1) {
                iH = ((c) this.access).h(field.getName());
            }
            list2.add(newCachedField(field, list2.size(), iH));
        }
    }

    private FieldSerializer$CachedFieldFactory getAsmFieldFactory() {
        if (asmFieldFactory == null) {
            asmFieldFactory = new AsmCachedFieldFactory();
        }
        return asmFieldFactory;
    }

    private FieldSerializer$CachedFieldFactory getObjectFieldFactory() {
        if (objectFieldFactory == null) {
            objectFieldFactory = new ObjectCachedFieldFactory();
        }
        return objectFieldFactory;
    }

    private FieldSerializer$CachedFieldFactory getUnsafeFieldFactory() {
        if (unsafeFieldFactory == null) {
            try {
                unsafeFieldFactory = (FieldSerializer$CachedFieldFactory) getClass().getClassLoader().loadClass("com.esotericsoftware.kryo.serializers.UnsafeCachedFieldFactory").newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Cannot create UnsafeFieldFactory", e);
            }
        }
        return unsafeFieldFactory;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(FieldSerializer$CachedField fieldSerializer$CachedField, FieldSerializer$CachedField fieldSerializer$CachedField2) {
        return compare2(fieldSerializer$CachedField, fieldSerializer$CachedField2);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public T copy(Kryo kryo, T t) {
        T tCreateCopy = createCopy(kryo, t);
        kryo.reference(tCreateCopy);
        if (this.config.isCopyTransient()) {
            int length = this.transientFields.length;
            for (int i = 0; i < length; i++) {
                this.transientFields[i].copy(t, tCreateCopy);
            }
        }
        int length2 = this.fields.length;
        for (int i2 = 0; i2 < length2; i2++) {
            this.fields[i2].copy(t, tCreateCopy);
        }
        return tCreateCopy;
    }

    public T create(Kryo kryo, Input input, Class<T> cls) {
        return (T) kryo.newInstance(cls);
    }

    public T createCopy(Kryo kryo, T t) {
        return (T) kryo.newInstance(t.getClass());
    }

    public String getCachedFieldName(FieldSerializer$CachedField fieldSerializer$CachedField) {
        return this.config.getCachedFieldNameStrategy().getName(fieldSerializer$CachedField);
    }

    public boolean getCopyTransient() {
        return this.config.isCopyTransient();
    }

    public FieldSerializer$CachedField getField(String str) {
        for (FieldSerializer$CachedField fieldSerializer$CachedField : this.fields) {
            if (getCachedFieldName(fieldSerializer$CachedField).equals(str)) {
                return fieldSerializer$CachedField;
            }
        }
        StringBuilder sbY = b.d.b.a.a.Y("Field \"", str, "\" not found on class: ");
        sbY.append(this.type.getName());
        throw new IllegalArgumentException(sbY.toString());
    }

    public FieldSerializer$CachedField[] getFields() {
        return this.fields;
    }

    public Class[] getGenerics() {
        return this.generics;
    }

    public final Generics getGenericsScope() {
        return this.genericsScope;
    }

    public Kryo getKryo() {
        return this.kryo;
    }

    public boolean getSerializeTransient() {
        return this.config.isSerializeTransient();
    }

    public FieldSerializer$CachedField[] getTransientFields() {
        return this.transientFields;
    }

    public Class getType() {
        return this.type;
    }

    public boolean getUseAsmEnabled() {
        return this.config.isUseAsm();
    }

    public boolean getUseMemRegions() {
        return this.useMemRegions;
    }

    public void initializeCachedFields() {
    }

    public FieldSerializer$CachedField newCachedField(Field field, int i, int i2) {
        FieldSerializer$CachedField fieldSerializer$CachedFieldNewMatchingCachedField;
        Class[] clsArr = {field.getType()};
        Type genericType = this.config.isOptimizedGenerics() ? field.getGenericType() : null;
        if (!this.config.isOptimizedGenerics() || genericType == clsArr[0]) {
            a$a a_a = a.a;
            fieldSerializer$CachedFieldNewMatchingCachedField = newMatchingCachedField(field, i2, clsArr[0], genericType, null);
        } else {
            fieldSerializer$CachedFieldNewMatchingCachedField = this.genericsUtil.newCachedFieldOfGenericType(field, i2, clsArr, genericType);
        }
        if (fieldSerializer$CachedFieldNewMatchingCachedField instanceof ObjectField) {
            this.hasObjectFields = true;
        }
        fieldSerializer$CachedFieldNewMatchingCachedField.field = field;
        fieldSerializer$CachedFieldNewMatchingCachedField.varIntsEnabled = this.varIntsEnabled;
        if (!this.config.isUseAsm()) {
            fieldSerializer$CachedFieldNewMatchingCachedField.offset = this.unsafeUtil.getObjectFieldOffset(field);
        }
        fieldSerializer$CachedFieldNewMatchingCachedField.access = (c) this.access;
        fieldSerializer$CachedFieldNewMatchingCachedField.accessIndex = i2;
        fieldSerializer$CachedFieldNewMatchingCachedField.canBeNull = (!this.config.isFieldsCanBeNull() || clsArr[0].isPrimitive() || field.isAnnotationPresent(NotNull.class)) ? false : true;
        if (this.kryo.isFinal(clsArr[0]) || this.config.isFixedFieldTypes()) {
            fieldSerializer$CachedFieldNewMatchingCachedField.valueClass = clsArr[0];
        }
        return fieldSerializer$CachedFieldNewMatchingCachedField;
    }

    public FieldSerializer$CachedField newMatchingCachedField(Field field, int i, Class cls, Type type, Class[] clsArr) {
        if (i != -1) {
            return getAsmFieldFactory().createCachedField(cls, field, this);
        }
        if (!this.config.isUseAsm()) {
            return getUnsafeFieldFactory().createCachedField(cls, field, this);
        }
        FieldSerializer$CachedField fieldSerializer$CachedFieldCreateCachedField = getObjectFieldFactory().createCachedField(cls, field, this);
        if (!this.config.isOptimizedGenerics()) {
            return fieldSerializer$CachedFieldCreateCachedField;
        }
        if (clsArr != null) {
            ((ObjectField) fieldSerializer$CachedFieldCreateCachedField).generics = clsArr;
            return fieldSerializer$CachedFieldCreateCachedField;
        }
        if (type == null) {
            return fieldSerializer$CachedFieldCreateCachedField;
        }
        ((ObjectField) fieldSerializer$CachedFieldCreateCachedField).generics = FieldSerializerGenericsUtil.getGenerics(type, this.kryo);
        a$a a_a = a.a;
        return fieldSerializer$CachedFieldCreateCachedField;
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public T read(Kryo kryo, Input input, Class<T> cls) {
        try {
            if (this.config.isOptimizedGenerics()) {
                if (this.typeParameters != null && this.generics != null) {
                    rebuildCachedFields();
                }
                if (this.genericsScope != null) {
                    kryo.getGenericsResolver().pushScope(cls, this.genericsScope);
                }
            }
            T tCreate = create(kryo, input, cls);
            kryo.reference(tCreate);
            for (FieldSerializer$CachedField fieldSerializer$CachedField : this.fields) {
                fieldSerializer$CachedField.read(input, tCreate);
            }
            if (this.config.isSerializeTransient()) {
                int length = this.transientFields.length;
                for (int i = 0; i < length; i++) {
                    this.transientFields[i].read(input, tCreate);
                }
            }
            return tCreate;
        } finally {
            if (this.config.isOptimizedGenerics() && this.genericsScope != null && kryo.getGenericsResolver() != null) {
                kryo.getGenericsResolver().popScope();
            }
        }
    }

    public void rebuildCachedFields() {
        rebuildCachedFields(false);
    }

    public void removeField(String str) {
        int i = 0;
        while (true) {
            FieldSerializer$CachedField[] fieldSerializer$CachedFieldArr = this.fields;
            if (i < fieldSerializer$CachedFieldArr.length) {
                FieldSerializer$CachedField fieldSerializer$CachedField = fieldSerializer$CachedFieldArr[i];
                if (getCachedFieldName(fieldSerializer$CachedField).equals(str)) {
                    FieldSerializer$CachedField[] fieldSerializer$CachedFieldArr2 = this.fields;
                    int length = fieldSerializer$CachedFieldArr2.length - 1;
                    FieldSerializer$CachedField[] fieldSerializer$CachedFieldArr3 = new FieldSerializer$CachedField[length];
                    System.arraycopy(fieldSerializer$CachedFieldArr2, 0, fieldSerializer$CachedFieldArr3, 0, i);
                    System.arraycopy(this.fields, i + 1, fieldSerializer$CachedFieldArr3, i, length - i);
                    this.fields = fieldSerializer$CachedFieldArr3;
                    this.removedFields.add(fieldSerializer$CachedField);
                    return;
                }
                i++;
            } else {
                int i2 = 0;
                while (true) {
                    FieldSerializer$CachedField[] fieldSerializer$CachedFieldArr4 = this.transientFields;
                    if (i2 >= fieldSerializer$CachedFieldArr4.length) {
                        StringBuilder sbY = b.d.b.a.a.Y("Field \"", str, "\" not found on class: ");
                        sbY.append(this.type.getName());
                        throw new IllegalArgumentException(sbY.toString());
                    }
                    FieldSerializer$CachedField fieldSerializer$CachedField2 = fieldSerializer$CachedFieldArr4[i2];
                    if (getCachedFieldName(fieldSerializer$CachedField2).equals(str)) {
                        FieldSerializer$CachedField[] fieldSerializer$CachedFieldArr5 = this.transientFields;
                        int length2 = fieldSerializer$CachedFieldArr5.length - 1;
                        FieldSerializer$CachedField[] fieldSerializer$CachedFieldArr6 = new FieldSerializer$CachedField[length2];
                        System.arraycopy(fieldSerializer$CachedFieldArr5, 0, fieldSerializer$CachedFieldArr6, 0, i2);
                        System.arraycopy(this.transientFields, i2 + 1, fieldSerializer$CachedFieldArr6, i2, length2 - i2);
                        this.transientFields = fieldSerializer$CachedFieldArr6;
                        this.removedFields.add(fieldSerializer$CachedField2);
                        return;
                    }
                    i2++;
                }
            }
        }
    }

    public void setCopyTransient(boolean z2) {
        this.config.setCopyTransient(z2);
    }

    public void setFieldsAsAccessible(boolean z2) {
        this.config.setFieldsAsAccessible(z2);
        rebuildCachedFields();
    }

    public void setFieldsCanBeNull(boolean z2) {
        this.config.setFieldsCanBeNull(z2);
        rebuildCachedFields();
    }

    public void setFixedFieldTypes(boolean z2) {
        this.config.setFixedFieldTypes(z2);
        rebuildCachedFields();
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public void setGenerics(Kryo kryo, Class[] clsArr) {
        if (this.config.isOptimizedGenerics()) {
            this.generics = clsArr;
            TypeVariable[] typeVariableArr = this.typeParameters;
            if (typeVariableArr == null || typeVariableArr.length <= 0) {
                return;
            }
            rebuildCachedFields(true);
        }
    }

    public void setIgnoreSyntheticFields(boolean z2) {
        this.config.setIgnoreSyntheticFields(z2);
        rebuildCachedFields();
    }

    public void setOptimizedGenerics(boolean z2) {
        this.config.setOptimizedGenerics(z2);
        rebuildCachedFields();
    }

    public void setSerializeTransient(boolean z2) {
        this.config.setSerializeTransient(z2);
    }

    public void setUseAsm(boolean z2) {
        this.config.setUseAsm(z2);
        rebuildCachedFields();
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public void write(Kryo kryo, Output output, T t) {
        a$a a_a = a.a;
        if (this.config.isOptimizedGenerics()) {
            if (this.typeParameters != null && this.generics != null) {
                rebuildCachedFields();
            }
            if (this.genericsScope != null) {
                kryo.getGenericsResolver().pushScope(this.type, this.genericsScope);
            }
        }
        for (FieldSerializer$CachedField fieldSerializer$CachedField : this.fields) {
            fieldSerializer$CachedField.write(output, t);
        }
        if (this.config.isSerializeTransient()) {
            int length = this.transientFields.length;
            for (int i = 0; i < length; i++) {
                this.transientFields[i].write(output, t);
            }
        }
        if (!this.config.isOptimizedGenerics() || this.genericsScope == null) {
            return;
        }
        kryo.getGenericsResolver().popScope();
    }

    public FieldSerializer(Kryo kryo, Class cls, Class[] clsArr) {
        this(kryo, cls, clsArr, kryo.getFieldSerializerConfig().clone());
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(FieldSerializer$CachedField fieldSerializer$CachedField, FieldSerializer$CachedField fieldSerializer$CachedField2) {
        return getCachedFieldName(fieldSerializer$CachedField).compareTo(getCachedFieldName(fieldSerializer$CachedField2));
    }

    public void rebuildCachedFields(boolean z2) {
        List<Field> listBuildValidFieldsFromCachedFields;
        List<Field> listBuildValidFieldsFromCachedFields2;
        a$a a_a = a.a;
        if (this.type.isInterface()) {
            this.fields = new FieldSerializer$CachedField[0];
            return;
        }
        this.hasObjectFields = false;
        if (this.config.isOptimizedGenerics()) {
            Generics genericsBuildGenericsScope = this.genericsUtil.buildGenericsScope(this.type, this.generics);
            this.genericsScope = genericsBuildGenericsScope;
            if (genericsBuildGenericsScope != null) {
                this.kryo.getGenericsResolver().pushScope(this.type, this.genericsScope);
            }
        }
        IntArray intArray = new IntArray();
        if (z2) {
            listBuildValidFieldsFromCachedFields = buildValidFieldsFromCachedFields(this.fields, intArray);
            listBuildValidFieldsFromCachedFields2 = buildValidFieldsFromCachedFields(this.transientFields, intArray);
        } else {
            ArrayList arrayList = new ArrayList();
            for (Class superclass = this.type; superclass != Object.class; superclass = superclass.getSuperclass()) {
                Field[] declaredFields = superclass.getDeclaredFields();
                if (declaredFields != null) {
                    for (Field field : declaredFields) {
                        if (!Modifier.isStatic(field.getModifiers())) {
                            arrayList.add(field);
                        }
                    }
                }
            }
            ObjectMap context = this.kryo.getContext();
            List<Field> listAsList = arrayList;
            if (this.useMemRegions && !this.config.isUseAsm() && unsafeAvailable) {
                try {
                    listAsList = arrayList;
                    listAsList = arrayList;
                    listAsList = Arrays.asList((Field[]) sortFieldsByOffsetMethod.invoke(null, arrayList));
                } catch (Exception e) {
                    throw new RuntimeException("Cannot invoke UnsafeUtil.sortFieldsByOffset()", e);
                }
            }
            listAsList = arrayList;
            listAsList = arrayList;
            listAsList = arrayList;
            listBuildValidFieldsFromCachedFields = buildValidFields(false, listAsList, context, intArray);
            listBuildValidFieldsFromCachedFields2 = buildValidFields(true, listAsList, context, intArray);
            if (this.config.isUseAsm() && !Util.IS_ANDROID && Modifier.isPublic(this.type.getModifiers()) && intArray.indexOf(1) != -1) {
                try {
                    this.access = c.a(this.type);
                } catch (RuntimeException unused) {
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(listBuildValidFieldsFromCachedFields.size());
        ArrayList arrayList3 = new ArrayList(listBuildValidFieldsFromCachedFields2.size());
        createCachedFields(intArray, listBuildValidFieldsFromCachedFields, arrayList2, 0);
        createCachedFields(intArray, listBuildValidFieldsFromCachedFields2, arrayList3, listBuildValidFieldsFromCachedFields.size());
        Collections.sort(arrayList2, this);
        this.fields = (FieldSerializer$CachedField[]) arrayList2.toArray(new FieldSerializer$CachedField[arrayList2.size()]);
        Collections.sort(arrayList3, this);
        this.transientFields = (FieldSerializer$CachedField[]) arrayList3.toArray(new FieldSerializer$CachedField[arrayList3.size()]);
        initializeCachedFields();
        if (this.genericsScope != null) {
            this.kryo.getGenericsResolver().popScope();
        }
        if (!z2) {
            Iterator<FieldSerializer$CachedField> it = this.removedFields.iterator();
            while (it.hasNext()) {
                removeField(it.next());
            }
        }
        this.annotationsUtil.processAnnotatedFields(this);
    }

    public FieldSerializer(Kryo kryo, Class cls, Class[] clsArr, FieldSerializerConfig fieldSerializerConfig) {
        this.fields = new FieldSerializer$CachedField[0];
        this.transientFields = new FieldSerializer$CachedField[0];
        this.removedFields = new HashSet<>();
        this.useMemRegions = false;
        this.hasObjectFields = false;
        this.varIntsEnabled = true;
        a$a a_a = a.a;
        this.config = fieldSerializerConfig;
        this.kryo = kryo;
        this.type = cls;
        this.generics = clsArr;
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        this.typeParameters = typeParameters;
        if (typeParameters != null && typeParameters.length != 0) {
            this.componentType = null;
        } else {
            this.componentType = cls.getComponentType();
        }
        this.genericsUtil = new FieldSerializerGenericsUtil(this);
        this.unsafeUtil = FieldSerializerUnsafeUtil$Factory.getInstance(this);
        this.annotationsUtil = new FieldSerializerAnnotationsUtil(this);
        rebuildCachedFields();
    }

    public void removeField(FieldSerializer$CachedField fieldSerializer$CachedField) {
        int i = 0;
        while (true) {
            FieldSerializer$CachedField[] fieldSerializer$CachedFieldArr = this.fields;
            if (i < fieldSerializer$CachedFieldArr.length) {
                FieldSerializer$CachedField fieldSerializer$CachedField2 = fieldSerializer$CachedFieldArr[i];
                if (fieldSerializer$CachedField2 == fieldSerializer$CachedField) {
                    int length = fieldSerializer$CachedFieldArr.length - 1;
                    FieldSerializer$CachedField[] fieldSerializer$CachedFieldArr2 = new FieldSerializer$CachedField[length];
                    System.arraycopy(fieldSerializer$CachedFieldArr, 0, fieldSerializer$CachedFieldArr2, 0, i);
                    System.arraycopy(this.fields, i + 1, fieldSerializer$CachedFieldArr2, i, length - i);
                    this.fields = fieldSerializer$CachedFieldArr2;
                    this.removedFields.add(fieldSerializer$CachedField2);
                    return;
                }
                i++;
            } else {
                int i2 = 0;
                while (true) {
                    FieldSerializer$CachedField[] fieldSerializer$CachedFieldArr3 = this.transientFields;
                    if (i2 < fieldSerializer$CachedFieldArr3.length) {
                        FieldSerializer$CachedField fieldSerializer$CachedField3 = fieldSerializer$CachedFieldArr3[i2];
                        if (fieldSerializer$CachedField3 == fieldSerializer$CachedField) {
                            int length2 = fieldSerializer$CachedFieldArr3.length - 1;
                            FieldSerializer$CachedField[] fieldSerializer$CachedFieldArr4 = new FieldSerializer$CachedField[length2];
                            System.arraycopy(fieldSerializer$CachedFieldArr3, 0, fieldSerializer$CachedFieldArr4, 0, i2);
                            System.arraycopy(this.transientFields, i2 + 1, fieldSerializer$CachedFieldArr4, i2, length2 - i2);
                            this.transientFields = fieldSerializer$CachedFieldArr4;
                            this.removedFields.add(fieldSerializer$CachedField3);
                            return;
                        }
                        i2++;
                    } else {
                        throw new IllegalArgumentException("Field \"" + fieldSerializer$CachedField + "\" not found on class: " + this.type.getName());
                    }
                }
            }
        }
    }
}
