package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelSku;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: ModelStoreListing.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelStoreListing {
    private final long id;
    private final ModelSku sku;

    /* JADX INFO: compiled from: ModelStoreListing.kt */
    public static final class Parser implements Model.Parser<ModelStoreListing> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public ModelStoreListing parse(final Model.JsonReader reader) throws IOException {
            final Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            reader.nextObject(new Action1<String>() { // from class: com.discord.models.domain.ModelStoreListing$Parser$parse$1
                @Override // rx.functions.Action1
                public final void call(String str) throws IOException {
                    if (str != null) {
                        int iHashCode = str.hashCode();
                        if (iHashCode != 3355) {
                            if (iHashCode == 113949 && str.equals("sku")) {
                                ref$ObjectRefC0.element = (T) ModelSku.Parser.INSTANCE.parse(reader);
                                return;
                            }
                        } else if (str.equals(ModelAuditLogEntry.CHANGE_KEY_ID)) {
                            ref$ObjectRef.element = (T) reader.nextLongOrNull();
                            return;
                        }
                    }
                    reader.skipValue();
                }
            });
            ModelSku modelSku = (ModelSku) ref$ObjectRefC0.element;
            Intrinsics3.checkNotNull(modelSku);
            Long l = (Long) ref$ObjectRef.element;
            return new ModelStoreListing(modelSku, l != null ? l.longValue() : 0L);
        }
    }

    public ModelStoreListing(ModelSku modelSku, long j) {
        Intrinsics3.checkNotNullParameter(modelSku, "sku");
        this.sku = modelSku;
        this.id = j;
    }

    public static /* synthetic */ ModelStoreListing copy$default(ModelStoreListing modelStoreListing, ModelSku modelSku, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            modelSku = modelStoreListing.sku;
        }
        if ((i & 2) != 0) {
            j = modelStoreListing.id;
        }
        return modelStoreListing.copy(modelSku, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelSku getSku() {
        return this.sku;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public final ModelStoreListing copy(ModelSku sku, long id2) {
        Intrinsics3.checkNotNullParameter(sku, "sku");
        return new ModelStoreListing(sku, id2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelStoreListing)) {
            return false;
        }
        ModelStoreListing modelStoreListing = (ModelStoreListing) other;
        return Intrinsics3.areEqual(this.sku, modelStoreListing.sku) && this.id == modelStoreListing.id;
    }

    public final long getId() {
        return this.id;
    }

    public final ModelSku getSku() {
        return this.sku;
    }

    public int hashCode() {
        ModelSku modelSku = this.sku;
        int iHashCode = modelSku != null ? modelSku.hashCode() : 0;
        long j = this.id;
        return (iHashCode * 31) + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelStoreListing(sku=");
        sbU.append(this.sku);
        sbU.append(", id=");
        return outline.C(sbU, this.id, ")");
    }
}
