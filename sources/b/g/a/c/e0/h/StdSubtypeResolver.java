package b.g.a.c.e0.h;

import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.JavaType;
import b.g.a.c.c0.AnnotatedClass;
import b.g.a.c.c0.AnnotatedClassResolver;
import b.g.a.c.c0.AnnotatedMember;
import b.g.a.c.e0.NamedType;
import b.g.a.c.e0.SubtypeResolver;
import b.g.a.c.z.MapperConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: renamed from: b.g.a.c.e0.h.i, reason: use source file name */
/* JADX INFO: compiled from: StdSubtypeResolver.java */
/* JADX INFO: loaded from: classes3.dex */
public class StdSubtypeResolver extends SubtypeResolver implements Serializable {
    private static final long serialVersionUID = 1;
    public LinkedHashSet<NamedType> _registeredSubtypes;

    @Override // b.g.a.c.e0.SubtypeResolver
    public Collection<NamedType> a(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        List<NamedType> listN;
        AnnotationIntrospector annotationIntrospectorE = mapperConfig.e();
        Class<?> clsD = javaType == null ? annotatedMember.d() : javaType._class;
        HashMap<NamedType, NamedType> map = new HashMap<>();
        LinkedHashSet<NamedType> linkedHashSet = this._registeredSubtypes;
        if (linkedHashSet != null) {
            for (NamedType namedType : linkedHashSet) {
                if (clsD.isAssignableFrom(namedType._class)) {
                    b(AnnotatedClassResolver.h(mapperConfig, namedType._class), namedType, mapperConfig, annotationIntrospectorE, map);
                }
            }
        }
        if (annotatedMember != null && (listN = annotationIntrospectorE.N(annotatedMember)) != null) {
            for (NamedType namedType2 : listN) {
                b(AnnotatedClassResolver.h(mapperConfig, namedType2._class), namedType2, mapperConfig, annotationIntrospectorE, map);
            }
        }
        b(AnnotatedClassResolver.h(mapperConfig, clsD), new NamedType(clsD, null), mapperConfig, annotationIntrospectorE, map);
        return new ArrayList(map.values());
    }

    public void b(AnnotatedClass annotatedClass, NamedType namedType, MapperConfig<?> mapperConfig, AnnotationIntrospector annotationIntrospector, HashMap<NamedType, NamedType> map) {
        String strO;
        if (!namedType.a() && (strO = annotationIntrospector.O(annotatedClass)) != null) {
            namedType = new NamedType(namedType._class, strO);
        }
        NamedType namedType2 = new NamedType(namedType._class, null);
        if (map.containsKey(namedType2)) {
            if (!namedType.a() || map.get(namedType2).a()) {
                return;
            }
            map.put(namedType2, namedType);
            return;
        }
        map.put(namedType2, namedType);
        List<NamedType> listN = annotationIntrospector.N(annotatedClass);
        if (listN == null || listN.isEmpty()) {
            return;
        }
        for (NamedType namedType3 : listN) {
            b(AnnotatedClassResolver.h(mapperConfig, namedType3._class), namedType3, mapperConfig, annotationIntrospector, map);
        }
    }
}
