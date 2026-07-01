package com.esotericsoftware.kryo.serializers;

import b.d.b.a.outline;
import b.e.a.Log;
import b.e.b.FieldAccess2;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.NotNull;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.FieldSerializerUnsafeUtil;
import com.esotericsoftware.kryo.util.IntArray;
import com.esotericsoftware.kryo.util.ObjectMap;
import com.esotericsoftware.kryo.util.Util;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
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
public class FieldSerializer<T> extends Serializer<T> implements Comparator<CachedField> {
    public static CachedFieldFactory asmFieldFactory;
    public static CachedFieldFactory objectFieldFactory;
    public static Method sortFieldsByOffsetMethod;
    public static boolean unsafeAvailable;
    public static CachedFieldFactory unsafeFieldFactory;
    public static Class<?> unsafeUtilClass;
    public Object access;
    private FieldSerializerAnnotationsUtil annotationsUtil;
    public final Class componentType;
    public final FieldSerializerConfig config;
    private CachedField[] fields;
    private Class[] generics;
    private Generics genericsScope;
    private FieldSerializerGenericsUtil genericsUtil;
    private boolean hasObjectFields;
    public final Kryo kryo;
    public HashSet<CachedField> removedFields;
    private CachedField[] transientFields;
    public final Class type;
    public final TypeVariable[] typeParameters;
    private FieldSerializerUnsafeUtil unsafeUtil;
    private boolean useMemRegions;
    private boolean varIntsEnabled;

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Bind {
        Class<? extends Serializer> value();
    }

    public interface CachedFieldFactory {
        CachedField createCachedField(Class cls, Field field, FieldSerializer fieldSerializer);
    }

    public interface CachedFieldNameStrategy {
        public static final CachedFieldNameStrategy DEFAULT = new CachedFieldNameStrategy() { // from class: com.esotericsoftware.kryo.serializers.FieldSerializer.CachedFieldNameStrategy.1
            @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedFieldNameStrategy
            public String getName(CachedField cachedField) {
                return cachedField.field.getName();
            }
        };
        public static final CachedFieldNameStrategy EXTENDED = new CachedFieldNameStrategy() { // from class: com.esotericsoftware.kryo.serializers.FieldSerializer.CachedFieldNameStrategy.2
            @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedFieldNameStrategy
            public String getName(CachedField cachedField) {
                return cachedField.field.getDeclaringClass().getSimpleName() + "." + cachedField.field.getName();
            }
        };

        String getName(CachedField cachedField);
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Optional {
        String value();
    }

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
            Log.a aVar = Log.a;
        }
    }

    public FieldSerializer(Kryo kryo, Class cls) {
        this(kryo, cls, null);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0060  */
    /* JADX WARN: Code duplicated, block: B:28:0x0069  */
    /* JADX WARN: Code duplicated, block: B:33:0x007e  */
    private List<Field> buildValidFields(boolean z2, List<Field> list, ObjectMap objectMap, IntArray intArray) {
        Optional optional;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Field field = list.get(i);
            int modifiers = field.getModifiers();
            if (Modifier.isTransient(modifiers) == z2 && !Modifier.isStatic(modifiers) && (!field.isSynthetic() || !this.config.isIgnoreSyntheticFields())) {
                if (field.isAccessible()) {
                    optional = (Optional) field.getAnnotation(Optional.class);
                    if (optional != null || objectMap.containsKey(optional.value())) {
                        arrayList.add(field);
                        intArray.add((Modifier.isFinal(modifiers) && Modifier.isPublic(modifiers) && Modifier.isPublic(field.getType().getModifiers())) ? 1 : 0);
                    }
                } else if (this.config.isSetFieldsAsAccessible()) {
                    try {
                        field.setAccessible(true);
                        optional = (Optional) field.getAnnotation(Optional.class);
                        if (optional != null) {
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

    private List<Field> buildValidFieldsFromCachedFields(CachedField[] cachedFieldArr, IntArray intArray) {
        ArrayList arrayList = new ArrayList(cachedFieldArr.length);
        for (CachedField cachedField : cachedFieldArr) {
            arrayList.add(cachedField.field);
            intArray.add(cachedField.accessIndex > -1 ? 1 : 0);
        }
        return arrayList;
    }

    private void createCachedFields(IntArray intArray, List<Field> list, List<CachedField> list2, int i) {
        if (!this.config.isUseAsm() && this.useMemRegions) {
            this.unsafeUtil.createUnsafeCacheFieldsAndRegions(list, list2, i, intArray);
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Field field = list.get(i2);
            int iH = -1;
            if (this.access != null && intArray.get(i + i2) == 1) {
                iH = ((FieldAccess2) this.access).h(field.getName());
            }
            list2.add(newCachedField(field, list2.size(), iH));
        }
    }

    private CachedFieldFactory getAsmFieldFactory() {
        if (asmFieldFactory == null) {
            asmFieldFactory = new AsmCachedFieldFactory();
        }
        return asmFieldFactory;
    }

    private CachedFieldFactory getObjectFieldFactory() {
        if (objectFieldFactory == null) {
            objectFieldFactory = new ObjectCachedFieldFactory();
        }
        return objectFieldFactory;
    }

    private CachedFieldFactory getUnsafeFieldFactory() {
        if (unsafeFieldFactory == null) {
            try {
                unsafeFieldFactory = (CachedFieldFactory) getClass().getClassLoader().loadClass("com.esotericsoftware.kryo.serializers.UnsafeCachedFieldFactory").newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Cannot create UnsafeFieldFactory", e);
            }
        }
        return unsafeFieldFactory;
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

    public String getCachedFieldName(CachedField cachedField) {
        return this.config.getCachedFieldNameStrategy().getName(cachedField);
    }

    public boolean getCopyTransient() {
        return this.config.isCopyTransient();
    }

    public CachedField getField(String str) {
        for (CachedField cachedField : this.fields) {
            if (getCachedFieldName(cachedField).equals(str)) {
                return cachedField;
            }
        }
        StringBuilder sbY = outline.Y("Field \"", str, "\" not found on class: ");
        sbY.append(this.type.getName());
        throw new IllegalArgumentException(sbY.toString());
    }

    public CachedField[] getFields() {
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

    public CachedField[] getTransientFields() {
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

    public CachedField newCachedField(Field field, int i, int i2) {
        CachedField cachedFieldNewMatchingCachedField;
        Class[] clsArr = {field.getType()};
        Type genericType = this.config.isOptimizedGenerics() ? field.getGenericType() : null;
        if (!this.config.isOptimizedGenerics() || genericType == clsArr[0]) {
            Log.a aVar = Log.a;
            cachedFieldNewMatchingCachedField = newMatchingCachedField(field, i2, clsArr[0], genericType, null);
        } else {
            cachedFieldNewMatchingCachedField = this.genericsUtil.newCachedFieldOfGenericType(field, i2, clsArr, genericType);
        }
        if (cachedFieldNewMatchingCachedField instanceof ObjectField) {
            this.hasObjectFields = true;
        }
        cachedFieldNewMatchingCachedField.field = field;
        cachedFieldNewMatchingCachedField.varIntsEnabled = this.varIntsEnabled;
        if (!this.config.isUseAsm()) {
            cachedFieldNewMatchingCachedField.offset = this.unsafeUtil.getObjectFieldOffset(field);
        }
        cachedFieldNewMatchingCachedField.access = (FieldAccess2) this.access;
        cachedFieldNewMatchingCachedField.accessIndex = i2;
        cachedFieldNewMatchingCachedField.canBeNull = (!this.config.isFieldsCanBeNull() || clsArr[0].isPrimitive() || field.isAnnotationPresent(NotNull.class)) ? false : true;
        if (this.kryo.isFinal(clsArr[0]) || this.config.isFixedFieldTypes()) {
            cachedFieldNewMatchingCachedField.valueClass = clsArr[0];
        }
        return cachedFieldNewMatchingCachedField;
    }

    public CachedField newMatchingCachedField(Field field, int i, Class cls, Type type, Class[] clsArr) {
        if (i != -1) {
            return getAsmFieldFactory().createCachedField(cls, field, this);
        }
        if (!this.config.isUseAsm()) {
            return getUnsafeFieldFactory().createCachedField(cls, field, this);
        }
        CachedField cachedFieldCreateCachedField = getObjectFieldFactory().createCachedField(cls, field, this);
        if (!this.config.isOptimizedGenerics()) {
            return cachedFieldCreateCachedField;
        }
        if (clsArr != null) {
            ((ObjectField) cachedFieldCreateCachedField).generics = clsArr;
            return cachedFieldCreateCachedField;
        }
        if (type == null) {
            return cachedFieldCreateCachedField;
        }
        ((ObjectField) cachedFieldCreateCachedField).generics = FieldSerializerGenericsUtil.getGenerics(type, this.kryo);
        Log.a aVar = Log.a;
        return cachedFieldCreateCachedField;
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
            for (CachedField cachedField : this.fields) {
                cachedField.read(input, tCreate);
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
            CachedField[] cachedFieldArr = this.fields;
            if (i < cachedFieldArr.length) {
                CachedField cachedField = cachedFieldArr[i];
                if (getCachedFieldName(cachedField).equals(str)) {
                    CachedField[] cachedFieldArr2 = this.fields;
                    int length = cachedFieldArr2.length - 1;
                    CachedField[] cachedFieldArr3 = new CachedField[length];
                    System.arraycopy(cachedFieldArr2, 0, cachedFieldArr3, 0, i);
                    System.arraycopy(this.fields, i + 1, cachedFieldArr3, i, length - i);
                    this.fields = cachedFieldArr3;
                    this.removedFields.add(cachedField);
                    return;
                }
                i++;
            } else {
                int i2 = 0;
                while (true) {
                    CachedField[] cachedFieldArr4 = this.transientFields;
                    if (i2 >= cachedFieldArr4.length) {
                        StringBuilder sbY = outline.Y("Field \"", str, "\" not found on class: ");
                        sbY.append(this.type.getName());
                        throw new IllegalArgumentException(sbY.toString());
                    }
                    CachedField cachedField2 = cachedFieldArr4[i2];
                    if (getCachedFieldName(cachedField2).equals(str)) {
                        CachedField[] cachedFieldArr5 = this.transientFields;
                        int length2 = cachedFieldArr5.length - 1;
                        CachedField[] cachedFieldArr6 = new CachedField[length2];
                        System.arraycopy(cachedFieldArr5, 0, cachedFieldArr6, 0, i2);
                        System.arraycopy(this.transientFields, i2 + 1, cachedFieldArr6, i2, length2 - i2);
                        this.transientFields = cachedFieldArr6;
                        this.removedFields.add(cachedField2);
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
        Log.a aVar = Log.a;
        if (this.config.isOptimizedGenerics()) {
            if (this.typeParameters != null && this.generics != null) {
                rebuildCachedFields();
            }
            if (this.genericsScope != null) {
                kryo.getGenericsResolver().pushScope(this.type, this.genericsScope);
            }
        }
        for (CachedField cachedField : this.fields) {
            cachedField.write(output, t);
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

    public static abstract class CachedField<X> {
        public FieldAccess2 access;
        public boolean canBeNull;
        public Field field;
        public Serializer serializer;
        public Class valueClass;
        public int accessIndex = -1;
        public long offset = -1;
        public boolean varIntsEnabled = true;

        public abstract void copy(Object obj, Object obj2);

        public Field getField() {
            return this.field;
        }

        public Serializer getSerializer() {
            return this.serializer;
        }

        public abstract void read(Input input, Object obj);

        public void setCanBeNull(boolean z2) {
            this.canBeNull = z2;
        }

        public void setClass(Class cls) {
            this.valueClass = cls;
            this.serializer = null;
        }

        public void setSerializer(Serializer serializer) {
            this.serializer = serializer;
        }

        public String toString() {
            return this.field.getName();
        }

        public abstract void write(Output output, Object obj);

        public void setClass(Class cls, Serializer serializer) {
            this.valueClass = cls;
            this.serializer = serializer;
        }
    }

    public FieldSerializer(Kryo kryo, Class cls, Class[] clsArr) {
        this(kryo, cls, clsArr, kryo.getFieldSerializerConfig().mo77clone());
    }

    @Override // java.util.Comparator
    public int compare(CachedField cachedField, CachedField cachedField2) {
        return getCachedFieldName(cachedField).compareTo(getCachedFieldName(cachedField2));
    }

    public void rebuildCachedFields(boolean z2) {
        List<Field> listBuildValidFieldsFromCachedFields;
        List<Field> listBuildValidFieldsFromCachedFields2;
        Log.a aVar = Log.a;
        if (this.type.isInterface()) {
            this.fields = new CachedField[0];
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
                    this.access = FieldAccess2.a(this.type);
                } catch (RuntimeException unused) {
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(listBuildValidFieldsFromCachedFields.size());
        ArrayList arrayList3 = new ArrayList(listBuildValidFieldsFromCachedFields2.size());
        createCachedFields(intArray, listBuildValidFieldsFromCachedFields, arrayList2, 0);
        createCachedFields(intArray, listBuildValidFieldsFromCachedFields2, arrayList3, listBuildValidFieldsFromCachedFields.size());
        Collections.sort(arrayList2, this);
        this.fields = (CachedField[]) arrayList2.toArray(new CachedField[arrayList2.size()]);
        Collections.sort(arrayList3, this);
        this.transientFields = (CachedField[]) arrayList3.toArray(new CachedField[arrayList3.size()]);
        initializeCachedFields();
        if (this.genericsScope != null) {
            this.kryo.getGenericsResolver().popScope();
        }
        if (!z2) {
            Iterator<CachedField> it = this.removedFields.iterator();
            while (it.hasNext()) {
                removeField(it.next());
            }
        }
        this.annotationsUtil.processAnnotatedFields(this);
    }

    public FieldSerializer(Kryo kryo, Class cls, Class[] clsArr, FieldSerializerConfig fieldSerializerConfig) {
        this.fields = new CachedField[0];
        this.transientFields = new CachedField[0];
        this.removedFields = new HashSet<>();
        this.useMemRegions = false;
        this.hasObjectFields = false;
        this.varIntsEnabled = true;
        Log.a aVar = Log.a;
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
        this.unsafeUtil = FieldSerializerUnsafeUtil.Factory.getInstance(this);
        this.annotationsUtil = new FieldSerializerAnnotationsUtil(this);
        rebuildCachedFields();
    }

    public void removeField(CachedField cachedField) {
        int i = 0;
        while (true) {
            CachedField[] cachedFieldArr = this.fields;
            if (i < cachedFieldArr.length) {
                CachedField cachedField2 = cachedFieldArr[i];
                if (cachedField2 == cachedField) {
                    int length = cachedFieldArr.length - 1;
                    CachedField[] cachedFieldArr2 = new CachedField[length];
                    System.arraycopy(cachedFieldArr, 0, cachedFieldArr2, 0, i);
                    System.arraycopy(this.fields, i + 1, cachedFieldArr2, i, length - i);
                    this.fields = cachedFieldArr2;
                    this.removedFields.add(cachedField2);
                    return;
                }
                i++;
            } else {
                int i2 = 0;
                while (true) {
                    CachedField[] cachedFieldArr3 = this.transientFields;
                    if (i2 < cachedFieldArr3.length) {
                        CachedField cachedField3 = cachedFieldArr3[i2];
                        if (cachedField3 == cachedField) {
                            int length2 = cachedFieldArr3.length - 1;
                            CachedField[] cachedFieldArr4 = new CachedField[length2];
                            System.arraycopy(cachedFieldArr3, 0, cachedFieldArr4, 0, i2);
                            System.arraycopy(this.transientFields, i2 + 1, cachedFieldArr4, i2, length2 - i2);
                            this.transientFields = cachedFieldArr4;
                            this.removedFields.add(cachedField3);
                            return;
                        }
                        i2++;
                    } else {
                        throw new IllegalArgumentException("Field \"" + cachedField + "\" not found on class: " + this.type.getName());
                    }
                }
            }
        }
    }
}
