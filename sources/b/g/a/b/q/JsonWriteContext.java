package b.g.a.b.q;

import b.d.b.a.outline;
import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonStreamContext;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.HashSet;

/* JADX INFO: renamed from: b.g.a.b.q.c, reason: use source file name */
/* JADX INFO: compiled from: JsonWriteContext.java */
/* JADX INFO: loaded from: classes3.dex */
public class JsonWriteContext extends JsonStreamContext {
    public final JsonWriteContext c;
    public DupDetector d;
    public JsonWriteContext e;
    public String f;
    public Object g;
    public boolean h;

    public JsonWriteContext(int i, JsonWriteContext jsonWriteContext, DupDetector dupDetector) {
        this.a = i;
        this.c = jsonWriteContext;
        this.d = dupDetector;
        this.f661b = -1;
    }

    @Override // b.g.a.b.JsonStreamContext
    public final String a() {
        return this.f;
    }

    @Override // b.g.a.b.JsonStreamContext
    public void d(Object obj) {
        this.g = obj;
    }

    public JsonWriteContext f() {
        JsonWriteContext jsonWriteContext = this.e;
        if (jsonWriteContext != null) {
            jsonWriteContext.j(1);
            return jsonWriteContext;
        }
        DupDetector dupDetector = this.d;
        JsonWriteContext jsonWriteContext2 = new JsonWriteContext(1, this, dupDetector == null ? null : dupDetector.a());
        this.e = jsonWriteContext2;
        return jsonWriteContext2;
    }

    public JsonWriteContext g(Object obj) {
        JsonWriteContext jsonWriteContext = this.e;
        if (jsonWriteContext != null) {
            jsonWriteContext.k(1, obj);
            return jsonWriteContext;
        }
        DupDetector dupDetector = this.d;
        JsonWriteContext jsonWriteContext2 = new JsonWriteContext(1, this, dupDetector == null ? null : dupDetector.a(), obj);
        this.e = jsonWriteContext2;
        return jsonWriteContext2;
    }

    public JsonWriteContext h() {
        JsonWriteContext jsonWriteContext = this.e;
        if (jsonWriteContext != null) {
            jsonWriteContext.j(2);
            return jsonWriteContext;
        }
        DupDetector dupDetector = this.d;
        JsonWriteContext jsonWriteContext2 = new JsonWriteContext(2, this, dupDetector == null ? null : dupDetector.a());
        this.e = jsonWriteContext2;
        return jsonWriteContext2;
    }

    public JsonWriteContext i(Object obj) {
        JsonWriteContext jsonWriteContext = this.e;
        if (jsonWriteContext != null) {
            jsonWriteContext.k(2, obj);
            return jsonWriteContext;
        }
        DupDetector dupDetector = this.d;
        JsonWriteContext jsonWriteContext2 = new JsonWriteContext(2, this, dupDetector == null ? null : dupDetector.a(), obj);
        this.e = jsonWriteContext2;
        return jsonWriteContext2;
    }

    public JsonWriteContext j(int i) {
        this.a = i;
        this.f661b = -1;
        this.f = null;
        this.h = false;
        this.g = null;
        DupDetector dupDetector = this.d;
        if (dupDetector != null) {
            dupDetector.f670b = null;
            dupDetector.c = null;
            dupDetector.d = null;
        }
        return this;
    }

    public JsonWriteContext k(int i, Object obj) {
        this.a = i;
        this.f661b = -1;
        this.f = null;
        this.h = false;
        this.g = obj;
        DupDetector dupDetector = this.d;
        if (dupDetector != null) {
            dupDetector.f670b = null;
            dupDetector.c = null;
            dupDetector.d = null;
        }
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x002f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0063  */
    /* JADX WARN: Code duplicated, block: B:30:0x0066  */
    public int l(String str) throws JsonProcessingException {
        boolean z2;
        Object obj;
        JsonGenerator jsonGenerator;
        if (this.a != 2 || this.h) {
            return 4;
        }
        this.h = true;
        this.f = str;
        DupDetector dupDetector = this.d;
        if (dupDetector != null) {
            String str2 = dupDetector.f670b;
            if (str2 == null) {
                dupDetector.f670b = str;
            } else {
                if (str.equals(str2)) {
                    z2 = true;
                } else {
                    String str3 = dupDetector.c;
                    if (str3 == null) {
                        dupDetector.c = str;
                    } else if (str.equals(str3)) {
                        z2 = true;
                    } else {
                        if (dupDetector.d == null) {
                            HashSet<String> hashSet = new HashSet<>(16);
                            dupDetector.d = hashSet;
                            hashSet.add(dupDetector.f670b);
                            dupDetector.d.add(dupDetector.c);
                        }
                        z2 = !dupDetector.d.add(str);
                    }
                }
                if (z2) {
                    obj = dupDetector.a;
                    String strY = outline.y("Duplicate field '", str, "'");
                    if (obj instanceof JsonGenerator) {
                        jsonGenerator = (JsonGenerator) obj;
                    } else {
                        jsonGenerator = null;
                    }
                    throw new JsonGenerationException(strY, jsonGenerator);
                }
            }
            z2 = false;
            if (z2) {
                obj = dupDetector.a;
                String strY2 = outline.y("Duplicate field '", str, "'");
                if (obj instanceof JsonGenerator) {
                    jsonGenerator = (JsonGenerator) obj;
                } else {
                    jsonGenerator = null;
                }
                throw new JsonGenerationException(strY2, jsonGenerator);
            }
        }
        return this.f661b < 0 ? 0 : 1;
    }

    public int m() {
        int i = this.a;
        if (i == 2) {
            if (!this.h) {
                return 5;
            }
            this.h = false;
            this.f661b++;
            return 2;
        }
        if (i == 1) {
            int i2 = this.f661b;
            this.f661b = i2 + 1;
            return i2 < 0 ? 0 : 1;
        }
        int i3 = this.f661b + 1;
        this.f661b = i3;
        return i3 == 0 ? 0 : 3;
    }

    public JsonWriteContext(int i, JsonWriteContext jsonWriteContext, DupDetector dupDetector, Object obj) {
        this.a = i;
        this.c = jsonWriteContext;
        this.d = dupDetector;
        this.f661b = -1;
        this.g = obj;
    }
}
