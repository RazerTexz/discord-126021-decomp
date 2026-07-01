package b.g.a.c.h0;

import b.d.b.a.outline;
import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonToken2;
import b.g.a.b.s.WritableTypeId;
import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializable;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import com.discord.widgets.chat.input.MentionUtils;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: b.g.a.c.h0.l, reason: use source file name */
/* JADX INFO: compiled from: TypeBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class TypeBase extends JavaType implements JsonSerializable {
    public static final TypeBindings j = TypeBindings.l;
    private static final long serialVersionUID = 1;
    public final TypeBindings _bindings;
    public final JavaType _superClass;
    public final JavaType[] _superInterfaces;

    public TypeBase(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, int i, Object obj, Object obj2, boolean z2) {
        super(cls, i, obj, obj2, z2);
        this._bindings = typeBindings == null ? j : typeBindings;
        this._superClass = javaType;
        this._superInterfaces = javaTypeArr;
    }

    public static StringBuilder J(Class<?> cls, StringBuilder sb, boolean z2) {
        if (!cls.isPrimitive()) {
            sb.append('L');
            String name = cls.getName();
            int length = name.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = name.charAt(i);
                if (cCharAt == '.') {
                    cCharAt = MentionUtils.SLASH_CHAR;
                }
                sb.append(cCharAt);
            }
            if (z2) {
                sb.append(';');
            }
        } else if (cls == Boolean.TYPE) {
            sb.append('Z');
        } else if (cls == Byte.TYPE) {
            sb.append('B');
        } else if (cls == Short.TYPE) {
            sb.append('S');
        } else if (cls == Character.TYPE) {
            sb.append('C');
        } else if (cls == Integer.TYPE) {
            sb.append('I');
        } else if (cls == Long.TYPE) {
            sb.append('J');
        } else if (cls == Float.TYPE) {
            sb.append('F');
        } else if (cls == Double.TYPE) {
            sb.append('D');
        } else {
            if (cls != Void.TYPE) {
                StringBuilder sbU = outline.U("Unrecognized primitive type: ");
                sbU.append(cls.getName());
                throw new IllegalStateException(sbU.toString());
            }
            sb.append('V');
        }
        return sb;
    }

    public String K() {
        return this._class.getName();
    }

    @Override // b.g.a.c.JsonSerializable
    public void c(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.j0(K());
    }

    @Override // b.g.a.c.JsonSerializable
    public void d(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        WritableTypeId writableTypeId = new WritableTypeId(this, JsonToken2.VALUE_STRING);
        typeSerializer.e(jsonGenerator, writableTypeId);
        jsonGenerator.j0(K());
        typeSerializer.f(jsonGenerator, writableTypeId);
    }

    @Override // b.g.a.b.s.ResolvedType
    public String e() {
        return K();
    }

    @Override // b.g.a.c.JavaType
    public JavaType f(int i) {
        return this._bindings.f(i);
    }

    @Override // b.g.a.c.JavaType
    public int g() {
        return this._bindings.j();
    }

    @Override // b.g.a.c.JavaType
    public final JavaType i(Class<?> cls) {
        JavaType javaTypeI;
        JavaType[] javaTypeArr;
        if (cls == this._class) {
            return this;
        }
        if (cls.isInterface() && (javaTypeArr = this._superInterfaces) != null) {
            int length = javaTypeArr.length;
            for (int i = 0; i < length; i++) {
                JavaType javaTypeI2 = this._superInterfaces[i].i(cls);
                if (javaTypeI2 != null) {
                    return javaTypeI2;
                }
            }
        }
        JavaType javaType = this._superClass;
        if (javaType == null || (javaTypeI = javaType.i(cls)) == null) {
            return null;
        }
        return javaTypeI;
    }

    @Override // b.g.a.c.JavaType
    public TypeBindings j() {
        return this._bindings;
    }

    @Override // b.g.a.c.JavaType
    public List<JavaType> n() {
        JavaType[] javaTypeArr = this._superInterfaces;
        if (javaTypeArr == null) {
            return Collections.emptyList();
        }
        int length = javaTypeArr.length;
        if (length != 0) {
            return length != 1 ? Arrays.asList(javaTypeArr) : Collections.singletonList(javaTypeArr[0]);
        }
        return Collections.emptyList();
    }

    @Override // b.g.a.c.JavaType
    public JavaType q() {
        return this._superClass;
    }
}
