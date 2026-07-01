package com.esotericsoftware.kryo.serializers;

import b.e.a.Log;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class FieldSerializerGenericsUtil {
    private Kryo kryo;
    private FieldSerializer serializer;

    public FieldSerializerGenericsUtil(FieldSerializer fieldSerializer) {
        this.serializer = fieldSerializer;
        this.kryo = fieldSerializer.getKryo();
    }

    public static Class[] getGenerics(Type type, Kryo kryo) {
        Class concreteClass;
        Class concreteClass2;
        if (type instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            return genericComponentType instanceof Class ? new Class[]{(Class) genericComponentType} : getGenerics(genericComponentType, kryo);
        }
        if (!(type instanceof ParameterizedType)) {
            return null;
        }
        Log.a aVar = Log.a;
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        Class[] clsArr = new Class[actualTypeArguments.length];
        int length = actualTypeArguments.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            Type type2 = actualTypeArguments[i2];
            Log.a aVar2 = Log.a;
            clsArr[i2] = Object.class;
            if (type2 instanceof Class) {
                clsArr[i2] = (Class) type2;
            } else if (type2 instanceof ParameterizedType) {
                clsArr[i2] = (Class) ((ParameterizedType) type2).getRawType();
            } else {
                if (type2 instanceof TypeVariable) {
                    GenericsResolver genericsResolver = kryo.getGenericsResolver();
                    if (genericsResolver.isSet() && (concreteClass2 = genericsResolver.getConcreteClass(((TypeVariable) type2).getName())) != null) {
                        clsArr[i2] = concreteClass2;
                    }
                } else if (type2 instanceof GenericArrayType) {
                    Type genericComponentType2 = ((GenericArrayType) type2).getGenericComponentType();
                    if (genericComponentType2 instanceof Class) {
                        clsArr[i2] = Array.newInstance((Class<?>) genericComponentType2, 0).getClass();
                    } else if (genericComponentType2 instanceof TypeVariable) {
                        GenericsResolver genericsResolver2 = kryo.getGenericsResolver();
                        if (genericsResolver2.isSet() && (concreteClass = genericsResolver2.getConcreteClass(((TypeVariable) genericComponentType2).getName())) != null) {
                            clsArr[i2] = Array.newInstance((Class<?>) concreteClass, 0).getClass();
                        }
                    } else {
                        Class[] generics = getGenerics(genericComponentType2, kryo);
                        if (generics != null) {
                            clsArr[i2] = generics[0];
                        }
                    }
                }
            }
            i++;
        }
        if (i == 0) {
            return null;
        }
        return clsArr;
    }

    private Class<?> getTypeVarConcreteClass(Class[] clsArr, int i, String str) {
        if (clsArr != null && clsArr.length > i) {
            return clsArr[i];
        }
        Log.a aVar = Log.a;
        GenericsResolver genericsResolver = this.kryo.getGenericsResolver();
        if (genericsResolver.isSet()) {
            return genericsResolver.getConcreteClass(str);
        }
        return null;
    }

    public Generics buildGenericsScope(Class cls, Class[] clsArr) {
        int i;
        Type genericSuperclass;
        TypeVariable[] typeParameters = null;
        while (true) {
            if (cls == null) {
                break;
            }
            FieldSerializer fieldSerializer = this.serializer;
            typeParameters = cls == fieldSerializer.type ? fieldSerializer.typeParameters : cls.getTypeParameters();
            if (typeParameters != null && typeParameters.length != 0) {
                break;
            }
            FieldSerializer fieldSerializer2 = this.serializer;
            Class superclass = fieldSerializer2.type;
            if (cls == superclass) {
                cls = fieldSerializer2.componentType;
                if (cls == null) {
                    do {
                        genericSuperclass = superclass.getGenericSuperclass();
                        superclass = superclass.getSuperclass();
                        if (genericSuperclass == null) {
                            break;
                        }
                    } while (!(genericSuperclass instanceof ParameterizedType));
                    if (genericSuperclass == null) {
                        break;
                    }
                    Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                    typeParameters = superclass.getTypeParameters();
                    clsArr = new Class[actualTypeArguments.length];
                    for (int i2 = 0; i2 < actualTypeArguments.length; i2++) {
                        clsArr[i2] = actualTypeArguments[i2] instanceof Class ? (Class) actualTypeArguments[i2] : Object.class;
                    }
                    break;
                }
            } else {
                cls = cls.getComponentType();
            }
        }
        if (typeParameters == null || typeParameters.length <= 0) {
            return null;
        }
        Log.a aVar = Log.a;
        HashMap map = new HashMap();
        int i3 = 0;
        for (TypeVariable typeVariable : typeParameters) {
            String name = typeVariable.getName();
            Log.a aVar2 = Log.a;
            Class<?> typeVarConcreteClass = getTypeVarConcreteClass(clsArr, i3, name);
            if (typeVarConcreteClass != null) {
                map.put(name, typeVarConcreteClass);
            }
            i3++;
        }
        return new Generics(map);
    }

    public Class[] computeFieldGenerics(Type type, Field field, Class[] clsArr) {
        Generics genericsScope;
        Class concreteClass;
        if (type == null) {
            return null;
        }
        if ((type instanceof TypeVariable) && this.serializer.getGenericsScope() != null) {
            Class concreteClass2 = this.serializer.getGenericsScope().getConcreteClass(((TypeVariable) type).getName());
            if (concreteClass2 == null) {
                return null;
            }
            clsArr[0] = concreteClass2;
            Class[] clsArr2 = {clsArr[0]};
            Log.a aVar = Log.a;
            return clsArr2;
        }
        if (!(type instanceof ParameterizedType)) {
            if (!(type instanceof GenericArrayType)) {
                return null;
            }
            Class[] clsArrComputeFieldGenerics = computeFieldGenerics(((GenericArrayType) type).getGenericComponentType(), field, new Class[]{clsArr[0]});
            Log.a aVar2 = Log.a;
            return clsArrComputeFieldGenerics;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments == null) {
            return null;
        }
        Class[] clsArr3 = new Class[actualTypeArguments.length];
        for (int i = 0; i < actualTypeArguments.length; i++) {
            Type type2 = actualTypeArguments[i];
            if (type2 instanceof Class) {
                clsArr3[i] = (Class) type2;
            } else if (type2 instanceof ParameterizedType) {
                clsArr3[i] = (Class) ((ParameterizedType) type2).getRawType();
            } else if ((type2 instanceof TypeVariable) && this.serializer.getGenericsScope() != null) {
                clsArr3[i] = this.serializer.getGenericsScope().getConcreteClass(((TypeVariable) type2).getName());
                if (clsArr3[i] == null) {
                    clsArr3[i] = Object.class;
                }
            } else if (type2 instanceof WildcardType) {
                clsArr3[i] = Object.class;
            } else if (type2 instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                if (genericComponentType instanceof Class) {
                    clsArr3[i] = Array.newInstance((Class<?>) genericComponentType, 0).getClass();
                } else if ((genericComponentType instanceof TypeVariable) && (genericsScope = this.serializer.getGenericsScope()) != null && (concreteClass = genericsScope.getConcreteClass(((TypeVariable) genericComponentType).getName())) != null) {
                    clsArr3[i] = Array.newInstance((Class<?>) concreteClass, 0).getClass();
                }
            } else {
                clsArr3[i] = null;
            }
        }
        Log.a aVar3 = Log.a;
        return clsArr3;
    }

    public FieldSerializer.CachedField newCachedFieldOfGenericType(Field field, int i, Class[] clsArr, Type type) {
        Log.a aVar = Log.a;
        buildGenericsScope(clsArr[0], getGenerics(type, this.kryo));
        if (clsArr[0] == Object.class && (type instanceof TypeVariable) && this.serializer.getGenericsScope() != null) {
            TypeVariable typeVariable = (TypeVariable) type;
            Class concreteClass = this.serializer.getGenericsScope().getConcreteClass(typeVariable.getName());
            if (concreteClass != null) {
                new Generics().add(typeVariable.getName(), concreteClass);
            }
        }
        Class[] clsArrComputeFieldGenerics = computeFieldGenerics(type, field, clsArr);
        FieldSerializer.CachedField cachedFieldNewMatchingCachedField = this.serializer.newMatchingCachedField(field, i, clsArr[0], type, clsArrComputeFieldGenerics);
        if (clsArrComputeFieldGenerics != null && (cachedFieldNewMatchingCachedField instanceof ObjectField) && clsArrComputeFieldGenerics.length > 0 && clsArrComputeFieldGenerics[0] != null) {
            ((ObjectField) cachedFieldNewMatchingCachedField).generics = clsArrComputeFieldGenerics;
        }
        return cachedFieldNewMatchingCachedField;
    }
}
