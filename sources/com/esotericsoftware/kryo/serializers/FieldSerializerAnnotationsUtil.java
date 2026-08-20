package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.factories.ReflectionSerializerFactory;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes.dex */
public final class FieldSerializerAnnotationsUtil {
    public FieldSerializerAnnotationsUtil(FieldSerializer fieldSerializer) {
    }

    public void processAnnotatedFields(FieldSerializer fieldSerializer) {
        FieldSerializer.CachedField[] fields = fieldSerializer.getFields();
        int length = fields.length;
        for (int i = 0; i < length; i++) {
            Field field = fields[i].getField();
            if (field.isAnnotationPresent(FieldSerializer.Bind.class)) {
                fields[i].setSerializer(ReflectionSerializerFactory.makeSerializer(fieldSerializer.getKryo(), ((FieldSerializer.Bind) field.getAnnotation(FieldSerializer.Bind.class)).value(), field.getClass()));
            }
            if (field.isAnnotationPresent(CollectionSerializer.BindCollection.class)) {
                field.isAnnotationPresent(MapSerializer.BindMap.class);
            }
            if (field.isAnnotationPresent(CollectionSerializer.BindCollection.class)) {
                if (fields[i].serializer != null) {
                    StringBuilder sbM833U = C1643a.m833U("CollectionSerialier.Bind cannot be used with field ");
                    sbM833U.append(fields[i].getField().getDeclaringClass().getName());
                    sbM833U.append(".");
                    sbM833U.append(fields[i].getField().getName());
                    sbM833U.append(", because it has a serializer already.");
                    throw new RuntimeException(sbM833U.toString());
                }
                CollectionSerializer.BindCollection bindCollection = (CollectionSerializer.BindCollection) field.getAnnotation(CollectionSerializer.BindCollection.class);
                if (!Collection.class.isAssignableFrom(fields[i].field.getType())) {
                    StringBuilder sbM833U2 = C1643a.m833U("CollectionSerialier.Bind should be used only with fields implementing java.util.Collection, but field ");
                    sbM833U2.append(fields[i].getField().getDeclaringClass().getName());
                    sbM833U2.append(".");
                    sbM833U2.append(fields[i].getField().getName());
                    sbM833U2.append(" does not implement it.");
                    throw new RuntimeException(sbM833U2.toString());
                }
                Class<? extends Serializer> clsElementSerializer = bindCollection.elementSerializer();
                if (clsElementSerializer == Serializer.class) {
                    clsElementSerializer = null;
                }
                Serializer serializerMakeSerializer = clsElementSerializer == null ? null : ReflectionSerializerFactory.makeSerializer(fieldSerializer.getKryo(), clsElementSerializer, field.getClass());
                boolean zElementsCanBeNull = bindCollection.elementsCanBeNull();
                Class<?> clsElementClass = bindCollection.elementClass();
                if (clsElementClass == Object.class) {
                    clsElementClass = null;
                }
                CollectionSerializer collectionSerializer = new CollectionSerializer();
                collectionSerializer.setElementsCanBeNull(zElementsCanBeNull);
                collectionSerializer.setElementClass(clsElementClass, serializerMakeSerializer);
                fields[i].setSerializer(collectionSerializer);
            }
            if (field.isAnnotationPresent(MapSerializer.BindMap.class)) {
                if (fields[i].serializer != null) {
                    StringBuilder sbM833U3 = C1643a.m833U("MapSerialier.Bind cannot be used with field ");
                    sbM833U3.append(fields[i].getField().getDeclaringClass().getName());
                    sbM833U3.append(".");
                    sbM833U3.append(fields[i].getField().getName());
                    sbM833U3.append(", because it has a serializer already.");
                    throw new RuntimeException(sbM833U3.toString());
                }
                MapSerializer.BindMap bindMap = (MapSerializer.BindMap) field.getAnnotation(MapSerializer.BindMap.class);
                if (!Map.class.isAssignableFrom(fields[i].field.getType())) {
                    StringBuilder sbM833U4 = C1643a.m833U("MapSerialier.Bind should be used only with fields implementing java.util.Map, but field ");
                    sbM833U4.append(fields[i].getField().getDeclaringClass().getName());
                    sbM833U4.append(".");
                    sbM833U4.append(fields[i].getField().getName());
                    sbM833U4.append(" does not implement it.");
                    throw new RuntimeException(sbM833U4.toString());
                }
                Class<? extends Serializer> clsValueSerializer = bindMap.valueSerializer();
                Class<? extends Serializer> clsKeySerializer = bindMap.keySerializer();
                if (clsValueSerializer == Serializer.class) {
                    clsValueSerializer = null;
                }
                if (clsKeySerializer == Serializer.class) {
                    clsKeySerializer = null;
                }
                Serializer serializerMakeSerializer2 = clsValueSerializer == null ? null : ReflectionSerializerFactory.makeSerializer(fieldSerializer.getKryo(), clsValueSerializer, field.getClass());
                Serializer serializerMakeSerializer3 = clsKeySerializer == null ? null : ReflectionSerializerFactory.makeSerializer(fieldSerializer.getKryo(), clsKeySerializer, field.getClass());
                boolean zValuesCanBeNull = bindMap.valuesCanBeNull();
                boolean zKeysCanBeNull = bindMap.keysCanBeNull();
                Class<?> clsKeyClass = bindMap.keyClass();
                Class<?> clsValueClass = bindMap.valueClass();
                if (clsKeyClass == Object.class) {
                    clsKeyClass = null;
                }
                Class<?> cls = clsValueClass != Object.class ? clsValueClass : null;
                MapSerializer mapSerializer = new MapSerializer();
                mapSerializer.setKeysCanBeNull(zKeysCanBeNull);
                mapSerializer.setValuesCanBeNull(zValuesCanBeNull);
                mapSerializer.setKeyClass(clsKeyClass, serializerMakeSerializer3);
                mapSerializer.setValueClass(cls, serializerMakeSerializer2);
                fields[i].setSerializer(mapSerializer);
            }
        }
    }
}
