package b0.a.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor$AutoCloseInputStream;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import d0.l;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Compressor.kt */
/* JADX INFO: loaded from: classes3.dex */
@e(c = "id.zelory.compressor.Compressor$compress$6", f = "Compressor.kt", l = {}, m = "invokeSuspend")
public final class b extends k implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    public final /* synthetic */ Function1 $compressionPatch;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ Uri $imageFileUri;
    public int label;
    private CoroutineScope p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Function1 function1, Context context, Uri uri, Continuation continuation) {
        super(2, continuation);
        this.$compressionPatch = function1;
        this.$context = context;
        this.$imageFileUri = uri;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkParameterIsNotNull(continuation, "completion");
        b bVar = new b(this.$compressionPatch, this.$context, this.$imageFileUri, continuation);
        bVar.p$ = (CoroutineScope) obj;
        return bVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super File> continuation) {
        Continuation<? super File> continuation2 = continuation;
        m.checkParameterIsNotNull(continuation2, "completion");
        b bVar = new b(this.$compressionPatch, this.$context, this.$imageFileUri, continuation2);
        bVar.p$ = coroutineScope;
        return bVar.invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) throws IOException {
        String string;
        d0.w.h.c.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        l.throwOnFailure(obj);
        b0.a.a.e.a aVar = new b0.a.a.e.a();
        this.$compressionPatch.invoke(aVar);
        Context context = this.$context;
        Uri uri = this.$imageFileUri;
        String str = d.a;
        m.checkParameterIsNotNull(context, "context");
        m.checkParameterIsNotNull(uri, "srcFileUri");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        File cacheDir = context.getCacheDir();
        m.checkExpressionValueIsNotNull(cacheDir, "context.cacheDir");
        sb2.append(cacheDir.getPath());
        String str2 = d.a;
        sb2.append(str2);
        sb2.append("compressor");
        sb2.append(str2);
        sb.append(sb2.toString());
        m.checkParameterIsNotNull(context, "context");
        m.checkParameterIsNotNull(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursorQuery = contentResolver.query(uri, new String[]{"_display_name"}, null, null, null);
        if (cursorQuery == null) {
            try {
                m.throwNpe();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    d0.y.b.closeFinally(cursorQuery, th);
                    throw th2;
                }
            }
        }
        int columnIndex = cursorQuery.getColumnIndex("_display_name");
        if (cursorQuery.moveToFirst()) {
            string = cursorQuery.getString(columnIndex);
            m.checkExpressionValueIsNotNull(string, "it.getString(nameIndex)");
            d0.y.b.closeFinally(cursorQuery, null);
        } else {
            String str3 = "IMG_" + new SimpleDateFormat("yyyyMMdd_", Locale.getDefault()).format(new Date()) + System.nanoTime();
            String type = contentResolver.getType(uri);
            if (m.areEqual(type, "image/jpg") || m.areEqual(type, "image/jpeg")) {
                string = str3 + ".jpeg";
            } else {
                if (!m.areEqual(type, "image/png")) {
                    throw new IllegalStateException(type + " fallback display name not supported");
                }
                string = str3 + ".png";
            }
            d0.y.b.closeFinally(cursorQuery, null);
        }
        sb.append(string);
        File file = new File(sb.toString());
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        file.deleteOnExit();
        ParcelFileDescriptor$AutoCloseInputStream parcelFileDescriptor$AutoCloseInputStream = new ParcelFileDescriptor$AutoCloseInputStream(context.getContentResolver().openFileDescriptor(uri, "r"));
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            try {
                d0.y.a.copyTo$default(parcelFileDescriptor$AutoCloseInputStream, fileOutputStream, 0, 2, null);
                d0.y.b.closeFinally(fileOutputStream, null);
                d0.y.b.closeFinally(parcelFileDescriptor$AutoCloseInputStream, null);
                for (b0.a.a.e.b bVar : aVar.a) {
                    while (!bVar.b(file)) {
                        file = bVar.a(file);
                    }
                }
                return file;
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    d0.y.b.closeFinally(fileOutputStream, th3);
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                d0.y.b.closeFinally(parcelFileDescriptor$AutoCloseInputStream, th5);
                throw th6;
            }
        }
    }
}
