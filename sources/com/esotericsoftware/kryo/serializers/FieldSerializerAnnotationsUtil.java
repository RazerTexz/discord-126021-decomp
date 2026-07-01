package com.esotericsoftware.kryo.serializers;

import b.d.b.a.a;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.factories.ReflectionSerializerFactory;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class FieldSerializerAnnotationsUtil {
    public FieldSerializerAnnotationsUtil(FieldSerializer fieldSerializer) {
    }

    public void processAnnotatedFields(FieldSerializer fieldSerializer) {
        FieldSerializer$CachedField[] fields = fieldSerializer.getFields();
        int length = fields.length;
        for (int i = 0; i < length; i++) {
            Field field = fields[i].getField();
            if (field.isAnnotationPresent(FieldSerializer$Bind.class)) {
                fields[i].setSerializer(ReflectionSerializerFactory.makeSerializer(fieldSerializer.getKryo(), ((FieldSerializer$Bind) field.getAnnotation(FieldSerializer$Bind.class)).value(), field.getClass()));
            }
            if (field.isAnnotationPresent(CollectionSerializer$BindCollection.class)) {
                field.isAnnotationPresent(MapSerializer$BindMap.class);
            }
            if (field.isAnnotationPresent(CollectionSerializer$BindCollection.class)) {
                if (fields[i].serializer != null) {
                    StringBuilder sbU = a.U("CollectionSerialier.Bind cannot be used with field ");
                    sbU.append(fields[i].getField().getDeclaringClass().getName());
                    sbU.append(".");
                    sbU.append(fields[i].getField().getName());
                    sbU.append(", because it has a serializer already.");
                    throw new RuntimeException(sbU.toString());
                }
                CollectionSerializer$BindCollection collectionSerializer$BindCollection = (CollectionSerializer$BindCollection) field.getAnnotation(CollectionSerializer$BindCollection.class);
                if (!Collection.class.isAssignableFrom(fields[i].field.getType())) {
                    StringBuilder sbU2 = a.U("CollectionSerialier.Bind should be used only with fields implementing java.util.Collection, but field ");
                    sbU2.append(fields[i].getField().getDeclaringClass().getName());
                    sbU2.append(".");
                    sbU2.append(fields[i].getField().getName());
                    sbU2.append(" does not implement it.");
                    throw new RuntimeException(sbU2.toString());
                }
                Class<? extends Serializer> clsElementSerializer = collectionSerializer$BindCollection.elementSerializer();
                if (clsElementSerializer == Serializer.class) {
                    clsElementSerializer = null;
                }
                Serializer serializerMakeSerializer = clsElementSerializer == null ? null : ReflectionSerializerFactory.makeSerializer(fieldSerializer.getKryo(), clsElementSerializer, field.getClass());
                boolean zElementsCanBeNull = collectionSerializer$BindCollection.elementsCanBeNull();
                Class<?> clsElementClass = collectionSerializer$BindCollection.elementClass();
                if (clsElementClass == Object.class) {
                    clsElementClass = null;
                }
                CollectionSerializer collectionSerializer = new CollectionSerializer();
                collectionSerializer.setElementsCanBeNull(zElementsCanBeNull);
                collectionSerializer.setElementClass(clsElementClass, serializerMakeSerializer);
                fields[i].setSerializer(collectionSerializer);
            }
            if (field.isAnnotationPresent(MapSerializer$BindMap.class)) {
                if (fields[i].serializer != null) {
                    StringBuilder sbU3 = a.U("MapSerialier.Bind cannot be used with field ");
                    sbU3.append(fields[i].getField().getDeclaringClass().getName());
                    sbU3.append(".");
                    sbU3.append(fields[i].getField().getName());
                    sbU3.append(", because it has a serializer already.");
                    throw new RuntimeException(sbU3.toString());
                }
                MapSerializer$BindMap mapSerializer$BindMap = (MapSerializer$BindMap) field.getAnnotation(MapSerializer$BindMap.class);
                if (!Map.class.isAssignableFrom(fields[i].field.getType())) {
                    StringBuilder sbU4 = a.U("MapSerialier.Bind should be used only with fields implementing java.util.Map, but field ");
                    sbU4.append(fields[i].getField().getDeclaringClass().getName());
                    sbU4.append(".");
                    sbU4.append(fields[i].getField().getName());
                    sbU4.append(" does not implement it.");
                    throw new RuntimeException(sbU4.toString());
                }
                Class<? extends Serializer> clsValueSerializer = mapSerializer$BindMap.valueSerializer();
                Class<? extends Serializer> clsKeySerializer = mapSerializer$BindMap.keySerializer();
                if (clsValueSerializer == Serializer.class) {
                    clsValueSerializer = null;
                }
                if (clsKeySerializer == Serializer.class) {
                    clsKeySerializer = null;
                }
                Serializer serializerMakeSerializer2 = clsValueSerializer == null ? null : ReflectionSerializerFactory.makeSerializer(fieldSerializer.getKryo(), clsValueSerializer, field.getClass());
                Serializer serializerMakeSerializer3 = clsKeySerializer == null ? null : ReflectionSerializerFactory.makeSerializer(fieldSerializer.getKryo(), clsKeySerializer, field.getClass());
                boolean zValuesCanBeNull = mapSerializer$BindMap.valuesCanBeNull();
                boolean zKeysCanBeNull = mapSerializer$BindMap.keysCanBeNull();
                Class<?> clsKeyClass = mapSerializer$BindMap.keyClass();
                Class<?> clsValueClass = mapSerializer$BindMap.valueClass();
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
