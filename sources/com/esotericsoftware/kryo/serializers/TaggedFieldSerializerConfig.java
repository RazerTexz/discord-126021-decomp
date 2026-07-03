package com.esotericsoftware.kryo.serializers;

import p007b.p106e.p107a.C1644a;

/* JADX INFO: loaded from: classes.dex */
public class TaggedFieldSerializerConfig extends FieldSerializerConfig {
    private boolean skipUnknownTags = false;

    @Deprecated
    public boolean isIgnoreUnknownTags() {
        return false;
    }

    public boolean isSkipUnknownTags() {
        return this.skipUnknownTags;
    }

    @Deprecated
    public void setIgnoreUnknownTags(boolean z2) {
    }

    public void setSkipUnknownTags(boolean z2) {
        this.skipUnknownTags = z2;
        C1644a.a aVar = C1644a.f3007a;
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializerConfig
    /* JADX INFO: renamed from: clone */
    public TaggedFieldSerializerConfig mo11454clone() {
        return (TaggedFieldSerializerConfig) super.mo11454clone();
    }
}
