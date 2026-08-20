package com.discord.models.domain;

import com.discord.api.application.Application;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: ModelLibraryApplication.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelLibraryApplication {
    private final Application application;
    private final long branchId;
    private final String createdAt;
    private final int flags;
    private final long skuId;

    /* JADX INFO: compiled from: ModelLibraryApplication.kt */
    public static final class Parser implements Model.Parser<ModelLibraryApplication> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public ModelLibraryApplication parse(final Model.JsonReader reader) throws IOException {
            final Ref$ObjectRef ref$ObjectRefM844c0 = C1643a.m844c0(reader, "reader");
            ref$ObjectRefM844c0.element = null;
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            final Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
            ref$ObjectRef3.element = null;
            final Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
            ref$ObjectRef4.element = null;
            reader.nextObject(new Action1<String>() { // from class: com.discord.models.domain.ModelLibraryApplication$Parser$parse$1
                /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
                @Override // p658rx.functions.Action1
                public final void call(String str) throws IOException {
                    if (str != null) {
                        switch (str.hashCode()) {
                            case -900217987:
                                if (str.equals("sku_id")) {
                                    ref$ObjectRef2.element = (T) reader.nextLongOrNull();
                                    return;
                                }
                                break;
                            case -787623720:
                                if (str.equals("branch_id")) {
                                    ref$ObjectRef4.element = (T) reader.nextLongOrNull();
                                    return;
                                }
                                break;
                            case 97513095:
                                if (str.equals("flags")) {
                                    ref$ObjectRef3.element = (T) reader.nextIntOrNull();
                                    return;
                                }
                                break;
                            case 1369680106:
                                if (str.equals("created_at")) {
                                    ref$ObjectRef.element = (T) reader.nextStringOrNull();
                                    return;
                                }
                                break;
                            case 1554253136:
                                if (str.equals("application")) {
                                    ref$ObjectRefM844c0.element = (T) ((Application) InboundGatewayGsonParser.fromJson(reader, Application.class));
                                    return;
                                }
                                break;
                        }
                    }
                    reader.skipValue();
                }
            });
            Application application = (Application) ref$ObjectRefM844c0.element;
            C12238m.checkNotNull(application);
            String str = (String) ref$ObjectRef.element;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            Long l = (Long) ref$ObjectRef2.element;
            long jLongValue = l != null ? l.longValue() : 0L;
            Integer num = (Integer) ref$ObjectRef3.element;
            int iIntValue = num != null ? num.intValue() : 0;
            Long l2 = (Long) ref$ObjectRef4.element;
            return new ModelLibraryApplication(application, str2, jLongValue, iIntValue, l2 != null ? l2.longValue() : 0L);
        }
    }

    public ModelLibraryApplication(Application application, String str, long j, int i, long j2) {
        C12238m.checkNotNullParameter(application, "application");
        C12238m.checkNotNullParameter(str, "createdAt");
        this.application = application;
        this.createdAt = str;
        this.skuId = j;
        this.flags = i;
        this.branchId = j2;
    }

    public static /* synthetic */ ModelLibraryApplication copy$default(ModelLibraryApplication modelLibraryApplication, Application application, String str, long j, int i, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            application = modelLibraryApplication.application;
        }
        if ((i2 & 2) != 0) {
            str = modelLibraryApplication.createdAt;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            j = modelLibraryApplication.skuId;
        }
        long j3 = j;
        if ((i2 & 8) != 0) {
            i = modelLibraryApplication.flags;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            j2 = modelLibraryApplication.branchId;
        }
        return modelLibraryApplication.copy(application, str2, j3, i3, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getSkuId() {
        return this.skuId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getFlags() {
        return this.flags;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getBranchId() {
        return this.branchId;
    }

    public final ModelLibraryApplication copy(Application application, String createdAt, long skuId, int flags, long branchId) {
        C12238m.checkNotNullParameter(application, "application");
        C12238m.checkNotNullParameter(createdAt, "createdAt");
        return new ModelLibraryApplication(application, createdAt, skuId, flags, branchId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelLibraryApplication)) {
            return false;
        }
        ModelLibraryApplication modelLibraryApplication = (ModelLibraryApplication) other;
        return C12238m.areEqual(this.application, modelLibraryApplication.application) && C12238m.areEqual(this.createdAt, modelLibraryApplication.createdAt) && this.skuId == modelLibraryApplication.skuId && this.flags == modelLibraryApplication.flags && this.branchId == modelLibraryApplication.branchId;
    }

    public final Application getApplication() {
        return this.application;
    }

    public final long getBranchId() {
        return this.branchId;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final long getSkuId() {
        return this.skuId;
    }

    public int hashCode() {
        Application application = this.application;
        int iHashCode = (application != null ? application.hashCode() : 0) * 31;
        String str = this.createdAt;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        long j = this.skuId;
        int i = (((iHashCode2 + ((int) (j ^ (j >>> 32)))) * 31) + this.flags) * 31;
        long j2 = this.branchId;
        return i + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ModelLibraryApplication(application=");
        sbM833U.append(this.application);
        sbM833U.append(", createdAt=");
        sbM833U.append(this.createdAt);
        sbM833U.append(", skuId=");
        sbM833U.append(this.skuId);
        sbM833U.append(", flags=");
        sbM833U.append(this.flags);
        sbM833U.append(", branchId=");
        return C1643a.m815C(sbM833U, this.branchId, ")");
    }
}
