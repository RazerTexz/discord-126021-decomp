package com.discord.utilities.rest;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import okhttp3.MultipartBody$Part;
import rx.Observable;

/* JADX INFO: compiled from: SendUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SendUtils$FileUpload {
    public static final SendUtils$FileUpload$Companion Companion = new SendUtils$FileUpload$Companion(null);
    public static final long SIZE_UNKNOWN = -1;
    private final Observable<Long> bytesWrittenObservable;
    private final long contentLength;
    private final String mimeType;
    private final String name;
    private final MultipartBody$Part part;

    public SendUtils$FileUpload(String str, long j, MultipartBody$Part multipartBody$Part, String str2, Observable<Long> observable) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(multipartBody$Part, "part");
        m.checkNotNullParameter(str2, "mimeType");
        m.checkNotNullParameter(observable, "bytesWrittenObservable");
        this.name = str;
        this.contentLength = j;
        this.part = multipartBody$Part;
        this.mimeType = str2;
        this.bytesWrittenObservable = observable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SendUtils$FileUpload copy$default(SendUtils$FileUpload sendUtils$FileUpload, String str, long j, MultipartBody$Part multipartBody$Part, String str2, Observable observable, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sendUtils$FileUpload.name;
        }
        if ((i & 2) != 0) {
            j = sendUtils$FileUpload.contentLength;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            multipartBody$Part = sendUtils$FileUpload.part;
        }
        MultipartBody$Part multipartBody$Part2 = multipartBody$Part;
        if ((i & 8) != 0) {
            str2 = sendUtils$FileUpload.mimeType;
        }
        String str3 = str2;
        if ((i & 16) != 0) {
            observable = sendUtils$FileUpload.bytesWrittenObservable;
        }
        return sendUtils$FileUpload.copy(str, j2, multipartBody$Part2, str3, observable);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getContentLength() {
        return this.contentLength;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MultipartBody$Part getPart() {
        return this.part;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    public final Observable<Long> component5() {
        return this.bytesWrittenObservable;
    }

    public final SendUtils$FileUpload copy(String name, long contentLength, MultipartBody$Part part, String mimeType, Observable<Long> bytesWrittenObservable) {
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(part, "part");
        m.checkNotNullParameter(mimeType, "mimeType");
        m.checkNotNullParameter(bytesWrittenObservable, "bytesWrittenObservable");
        return new SendUtils$FileUpload(name, contentLength, part, mimeType, bytesWrittenObservable);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SendUtils$FileUpload)) {
            return false;
        }
        SendUtils$FileUpload sendUtils$FileUpload = (SendUtils$FileUpload) other;
        return m.areEqual(this.name, sendUtils$FileUpload.name) && this.contentLength == sendUtils$FileUpload.contentLength && m.areEqual(this.part, sendUtils$FileUpload.part) && m.areEqual(this.mimeType, sendUtils$FileUpload.mimeType) && m.areEqual(this.bytesWrittenObservable, sendUtils$FileUpload.bytesWrittenObservable);
    }

    public final Observable<Long> getBytesWrittenObservable() {
        return this.bytesWrittenObservable;
    }

    public final long getContentLength() {
        return this.contentLength;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getName() {
        return this.name;
    }

    public final MultipartBody$Part getPart() {
        return this.part;
    }

    public int hashCode() {
        String str = this.name;
        int iA = (b.a(this.contentLength) + ((str != null ? str.hashCode() : 0) * 31)) * 31;
        MultipartBody$Part multipartBody$Part = this.part;
        int iHashCode = (iA + (multipartBody$Part != null ? multipartBody$Part.hashCode() : 0)) * 31;
        String str2 = this.mimeType;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Observable<Long> observable = this.bytesWrittenObservable;
        return iHashCode2 + (observable != null ? observable.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("FileUpload(name=");
        sbU.append(this.name);
        sbU.append(", contentLength=");
        sbU.append(this.contentLength);
        sbU.append(", part=");
        sbU.append(this.part);
        sbU.append(", mimeType=");
        sbU.append(this.mimeType);
        sbU.append(", bytesWrittenObservable=");
        sbU.append(this.bytesWrittenObservable);
        sbU.append(")");
        return sbU.toString();
    }
}
