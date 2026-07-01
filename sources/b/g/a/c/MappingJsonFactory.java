package b.g.a.c;

import b.g.a.b.JsonFactory;
import b.g.a.b.ObjectCodec;

/* JADX INFO: renamed from: b.g.a.c.q, reason: use source file name */
/* JADX INFO: compiled from: MappingJsonFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class MappingJsonFactory extends JsonFactory {
    private static final long serialVersionUID = -1;

    public MappingJsonFactory() {
        super(null);
        this._objectCodec = new ObjectMapper(this, null, null);
    }

    @Override // b.g.a.b.JsonFactory
    public ObjectCodec b() {
        return (ObjectMapper) this._objectCodec;
    }

    public MappingJsonFactory(ObjectMapper objectMapper) {
        super(objectMapper);
    }
}
