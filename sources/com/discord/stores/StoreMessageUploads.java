package com.discord.stores;

import com.discord.utilities.rest.SendUtils;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreMessageUploads.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageUploads extends StoreV2 {
    private final HashMap<String, MessageUploadState> uploads = new HashMap<>();

    /* JADX INFO: compiled from: StoreMessageUploads.kt */
    public static abstract class MessageUploadState {

        /* JADX INFO: compiled from: StoreMessageUploads.kt */
        public static final class None extends MessageUploadState {
            public static final None INSTANCE = new None();

            private None() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreMessageUploads.kt */
        public static final /* data */ class Preprocessing extends MessageUploadState {
            private final String displayName;
            private final String mimeType;
            private final int numFiles;

            public Preprocessing(int i, String str, String str2) {
                super(null);
                this.numFiles = i;
                this.displayName = str;
                this.mimeType = str2;
            }

            public static /* synthetic */ Preprocessing copy$default(Preprocessing preprocessing, int i, String str, String str2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = preprocessing.numFiles;
                }
                if ((i2 & 2) != 0) {
                    str = preprocessing.displayName;
                }
                if ((i2 & 4) != 0) {
                    str2 = preprocessing.mimeType;
                }
                return preprocessing.copy(i, str, str2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getNumFiles() {
                return this.numFiles;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getDisplayName() {
                return this.displayName;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getMimeType() {
                return this.mimeType;
            }

            public final Preprocessing copy(int numFiles, String displayName, String mimeType) {
                return new Preprocessing(numFiles, displayName, mimeType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Preprocessing)) {
                    return false;
                }
                Preprocessing preprocessing = (Preprocessing) other;
                return this.numFiles == preprocessing.numFiles && C12238m.areEqual(this.displayName, preprocessing.displayName) && C12238m.areEqual(this.mimeType, preprocessing.mimeType);
            }

            public final String getDisplayName() {
                return this.displayName;
            }

            public final String getMimeType() {
                return this.mimeType;
            }

            public final int getNumFiles() {
                return this.numFiles;
            }

            public int hashCode() {
                int i = this.numFiles * 31;
                String str = this.displayName;
                int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.mimeType;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Preprocessing(numFiles=");
                sbM833U.append(this.numFiles);
                sbM833U.append(", displayName=");
                sbM833U.append(this.displayName);
                sbM833U.append(", mimeType=");
                return C1643a.m822J(sbM833U, this.mimeType, ")");
            }
        }

        /* JADX INFO: compiled from: StoreMessageUploads.kt */
        public static final /* data */ class Uploading extends MessageUploadState {
            private final List<SendUtils.FileUpload> uploads;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Uploading(List<SendUtils.FileUpload> list) {
                super(null);
                C12238m.checkNotNullParameter(list, "uploads");
                this.uploads = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Uploading copy$default(Uploading uploading, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = uploading.uploads;
                }
                return uploading.copy(list);
            }

            public final List<SendUtils.FileUpload> component1() {
                return this.uploads;
            }

            public final Uploading copy(List<SendUtils.FileUpload> uploads) {
                C12238m.checkNotNullParameter(uploads, "uploads");
                return new Uploading(uploads);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Uploading) && C12238m.areEqual(this.uploads, ((Uploading) other).uploads);
                }
                return true;
            }

            public final List<SendUtils.FileUpload> getUploads() {
                return this.uploads;
            }

            public int hashCode() {
                List<SendUtils.FileUpload> list = this.uploads;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return C1643a.m824L(C1643a.m833U("Uploading(uploads="), this.uploads, ")");
            }
        }

        private MessageUploadState() {
        }

        public /* synthetic */ MessageUploadState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @StoreThread
    private final void updateState(String nonce, MessageUploadState uploadState) {
        this.uploads.put(nonce, uploadState);
        markChanged();
    }

    @StoreThread
    public final void bindUpload(String nonce, List<SendUtils.FileUpload> uploads) {
        C12238m.checkNotNullParameter(nonce, "nonce");
        C12238m.checkNotNullParameter(uploads, "uploads");
        updateState(nonce, new MessageUploadState.Uploading(uploads));
    }

    public final MessageUploadState getUploadProgress(String nonce) {
        C12238m.checkNotNullParameter(nonce, "nonce");
        MessageUploadState messageUploadState = this.uploads.get(nonce);
        return messageUploadState != null ? messageUploadState : MessageUploadState.None.INSTANCE;
    }

    @StoreThread
    public final void onPreprocessing(String nonce, int numFiles, String displayName, String mimeType) {
        C12238m.checkNotNullParameter(nonce, "nonce");
        updateState(nonce, new MessageUploadState.Preprocessing(numFiles, displayName, mimeType));
    }
}
