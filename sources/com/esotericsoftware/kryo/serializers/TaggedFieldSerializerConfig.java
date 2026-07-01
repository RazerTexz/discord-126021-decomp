package com.esotericsoftware.kryo.serializers;

import b.e.a.Log;

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
        Log.a aVar = Log.a;
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializerConfig
    /* JADX INFO: renamed from: clone */
    public TaggedFieldSerializerConfig mo77clone() {
        return (TaggedFieldSerializerConfig) super.mo77clone();
    }
}
