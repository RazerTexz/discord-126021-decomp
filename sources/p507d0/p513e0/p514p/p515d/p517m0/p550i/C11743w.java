package p507d0.p513e0.p514p.p515d.p517m0.p550i;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.w */
/* JADX INFO: compiled from: WireFormat.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11743w {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.w$c */
    /* JADX INFO: compiled from: WireFormat.java */
    public enum c {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(AbstractC11723c.f24100j),
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

        /* JADX INFO: renamed from: A */
        public static final b f24189A;

        /* JADX INFO: renamed from: B */
        public static final /* synthetic */ b[] f24190B;

        /* JADX INFO: renamed from: j */
        public static final b f24191j;

        /* JADX INFO: renamed from: k */
        public static final b f24192k;

        /* JADX INFO: renamed from: l */
        public static final b f24193l;

        /* JADX INFO: renamed from: m */
        public static final b f24194m;

        /* JADX INFO: renamed from: n */
        public static final b f24195n;

        /* JADX INFO: renamed from: o */
        public static final b f24196o;

        /* JADX INFO: renamed from: p */
        public static final b f24197p;

        /* JADX INFO: renamed from: q */
        public static final b f24198q;

        /* JADX INFO: renamed from: r */
        public static final b f24199r;

        /* JADX INFO: renamed from: s */
        public static final b f24200s;

        /* JADX INFO: renamed from: t */
        public static final b f24201t;

        /* JADX INFO: renamed from: u */
        public static final b f24202u;

        /* JADX INFO: renamed from: v */
        public static final b f24203v;

        /* JADX INFO: renamed from: w */
        public static final b f24204w;

        /* JADX INFO: renamed from: x */
        public static final b f24205x;

        /* JADX INFO: renamed from: y */
        public static final b f24206y;

        /* JADX INFO: renamed from: z */
        public static final b f24207z;
        private final c javaType;
        private final int wireType;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.i.w$b$a */
        /* JADX INFO: compiled from: WireFormat.java */
        public static enum a extends b {
            public a(String str, int i, c cVar, int i2) {
                super(str, i, cVar, i2, null);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.C11743w.b
            public boolean isPackable() {
                return false;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.i.w$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: WireFormat.java */
        public static enum C13326b extends b {
            public C13326b(String str, int i, c cVar, int i2) {
                super(str, i, cVar, i2, null);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.C11743w.b
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

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.C11743w.b
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

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.C11743w.b
            public boolean isPackable() {
                return false;
            }
        }

        static {
            b bVar = new b("DOUBLE", 0, c.DOUBLE, 1);
            f24191j = bVar;
            b bVar2 = new b("FLOAT", 1, c.FLOAT, 5);
            f24192k = bVar2;
            c cVar = c.LONG;
            b bVar3 = new b("INT64", 2, cVar, 0);
            f24193l = bVar3;
            b bVar4 = new b("UINT64", 3, cVar, 0);
            f24194m = bVar4;
            c cVar2 = c.INT;
            b bVar5 = new b("INT32", 4, cVar2, 0);
            f24195n = bVar5;
            b bVar6 = new b("FIXED64", 5, cVar, 1);
            f24196o = bVar6;
            b bVar7 = new b("FIXED32", 6, cVar2, 5);
            f24197p = bVar7;
            b bVar8 = new b("BOOL", 7, c.BOOLEAN, 0);
            f24198q = bVar8;
            a aVar = new a("STRING", 8, c.STRING, 2);
            f24199r = aVar;
            c cVar3 = c.MESSAGE;
            C13326b c13326b = new C13326b("GROUP", 9, cVar3, 3);
            f24200s = c13326b;
            c cVar4 = new c("MESSAGE", 10, cVar3, 2);
            f24201t = cVar4;
            d dVar = new d("BYTES", 11, c.BYTE_STRING, 2);
            f24202u = dVar;
            b bVar9 = new b("UINT32", 12, cVar2, 0);
            f24203v = bVar9;
            b bVar10 = new b("ENUM", 13, c.ENUM, 0);
            f24204w = bVar10;
            b bVar11 = new b("SFIXED32", 14, cVar2, 5);
            f24205x = bVar11;
            b bVar12 = new b("SFIXED64", 15, cVar, 1);
            f24206y = bVar12;
            b bVar13 = new b("SINT32", 16, cVar2, 0);
            f24207z = bVar13;
            b bVar14 = new b("SINT64", 17, cVar, 0);
            f24189A = bVar14;
            f24190B = new b[]{bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, aVar, c13326b, cVar4, dVar, bVar9, bVar10, bVar11, bVar12, bVar13, bVar14};
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
            return (b[]) f24190B.clone();
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
