package d0.e0.p.d.m0.i;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.w, reason: use source file name */
/* JADX INFO: compiled from: WireFormat.java */
/* JADX INFO: loaded from: classes3.dex */
public final class WireFormat {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.w$c */
    /* JADX INFO: compiled from: WireFormat.java */
    public enum c {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(ByteString3.j),
        ENUM(null),
        MESSAGE(null);

        private final Object defaultDefault;

        c(Object obj) {
            this.defaultDefault = obj;
        }
    }

    public static int getTagFieldNumber(int i) {
        return i >>> 3;
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'l' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.w$b */
    /* JADX INFO: compiled from: WireFormat.java */
    public static class b {
        public static final b A;
        public static final /* synthetic */ b[] B;
        public static final b j;
        public static final b k;
        public static final b l;
        public static final b m;
        public static final b n;
        public static final b o;
        public static final b p;
        public static final b q;
        public static final b r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final b f3434s;
        public static final b t;
        public static final b u;
        public static final b v;
        public static final b w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final b f3435x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final b f3436y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final b f3437z;
        private final c javaType;
        private final int wireType;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.i.w$b$a */
        /* JADX INFO: compiled from: WireFormat.java */
        public static enum a extends b {
            public a(String str, int i, c cVar, int i2) {
                super(str, i, cVar, i2, null);
            }

            @Override // d0.e0.p.d.m0.i.WireFormat.b
            public boolean isPackable() {
                return false;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.i.w$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: WireFormat.java */
        public static enum C0402b extends b {
            public C0402b(String str, int i, c cVar, int i2) {
                super(str, i, cVar, i2, null);
            }

            @Override // d0.e0.p.d.m0.i.WireFormat.b
            public boolean isPackable() {
                return false;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.i.w$b$c */
        /* JADX INFO: compiled from: WireFormat.java */
        public static enum c extends b {
            public c(String str, int i, c cVar, int i2) {
                super(str, i, cVar, i2, null);
            }

            @Override // d0.e0.p.d.m0.i.WireFormat.b
            public boolean isPackable() {
                return false;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.i.w$b$d */
        /* JADX INFO: compiled from: WireFormat.java */
        public static enum d extends b {
            public d(String str, int i, c cVar, int i2) {
                super(str, i, cVar, i2, null);
            }

            @Override // d0.e0.p.d.m0.i.WireFormat.b
            public boolean isPackable() {
                return false;
            }
        }

        static {
            b bVar = new b("DOUBLE", 0, c.DOUBLE, 1);
            j = bVar;
            b bVar2 = new b("FLOAT", 1, c.FLOAT, 5);
            k = bVar2;
            c cVar = c.LONG;
            b bVar3 = new b("INT64", 2, cVar, 0);
            l = bVar3;
            b bVar4 = new b("UINT64", 3, cVar, 0);
            m = bVar4;
            c cVar2 = c.INT;
            b bVar5 = new b("INT32", 4, cVar2, 0);
            n = bVar5;
            b bVar6 = new b("FIXED64", 5, cVar, 1);
            o = bVar6;
            b bVar7 = new b("FIXED32", 6, cVar2, 5);
            p = bVar7;
            b bVar8 = new b("BOOL", 7, c.BOOLEAN, 0);
            q = bVar8;
            a aVar = new a("STRING", 8, c.STRING, 2);
            r = aVar;
            c cVar3 = c.MESSAGE;
            C0402b c0402b = new C0402b("GROUP", 9, cVar3, 3);
            f3434s = c0402b;
            c cVar4 = new c("MESSAGE", 10, cVar3, 2);
            t = cVar4;
            d dVar = new d("BYTES", 11, c.BYTE_STRING, 2);
            u = dVar;
            b bVar9 = new b("UINT32", 12, cVar2, 0);
            v = bVar9;
            b bVar10 = new b("ENUM", 13, c.ENUM, 0);
            w = bVar10;
            b bVar11 = new b("SFIXED32", 14, cVar2, 5);
            f3435x = bVar11;
            b bVar12 = new b("SFIXED64", 15, cVar, 1);
            f3436y = bVar12;
            b bVar13 = new b("SINT32", 16, cVar2, 0);
            f3437z = bVar13;
            b bVar14 = new b("SINT64", 17, cVar, 0);
            A = bVar14;
            B = new b[]{bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, aVar, c0402b, cVar4, dVar, bVar9, bVar10, bVar11, bVar12, bVar13, bVar14};
        }

        public b(String str, int i, c cVar, int i2) {
            super(str, i);
            this.javaType = cVar;
            this.wireType = i2;
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) B.clone();
        }

        public c getJavaType() {
            return this.javaType;
        }

        public int getWireType() {
            return this.wireType;
        }

        public boolean isPackable() {
            return true;
        }

        public b(String str, int i, c cVar, int i2, a aVar) {
            super(str, i);
            this.javaType = cVar;
            this.wireType = i2;
        }
    }
}
