package b0.a.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.core.app.NotificationCompat;
import b0.a.a.e.Compression;
import b0.a.a.e.Constraint2;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.y.Closeable;
import d0.y.IOStreams;
import d0.z.d.Intrinsics3;
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

/* JADX INFO: renamed from: b0.a.a.b, reason: use source file name */
/* JADX INFO: compiled from: Compressor.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "id.zelory.compressor.Compressor$compress$6", f = "Compressor.kt", l = {}, m = "invokeSuspend")
public final class Compressor2 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    public final /* synthetic */ Function1 $compressionPatch;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ Uri $imageFileUri;
    public int label;
    private CoroutineScope p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Compressor2(Function1 function1, Context context, Uri uri, Continuation continuation) {
        super(2, continuation);
        this.$compressionPatch = function1;
        this.$context = context;
        this.$imageFileUri = uri;
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics3.checkParameterIsNotNull(continuation, "completion");
        Compressor2 compressor2 = new Compressor2(this.$compressionPatch, this.$context, this.$imageFileUri, continuation);
        compressor2.p$ = (CoroutineScope) obj;
        return compressor2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super File> continuation) {
        Continuation<? super File> continuation2 = continuation;
        Intrinsics3.checkParameterIsNotNull(continuation2, "completion");
        Compressor2 compressor2 = new Compressor2(this.$compressionPatch, this.$context, this.$imageFileUri, continuation2);
        compressor2.p$ = coroutineScope;
        return compressor2.invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        String string;
        Intrinsics2.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Result3.throwOnFailure(obj);
        Compression compression = new Compression();
        this.$compressionPatch.invoke(compression);
        Context context = this.$context;
        Uri uri = this.$imageFileUri;
        String str = Util3.a;
        Intrinsics3.checkParameterIsNotNull(context, "context");
        Intrinsics3.checkParameterIsNotNull(uri, "srcFileUri");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        File cacheDir = context.getCacheDir();
        Intrinsics3.checkExpressionValueIsNotNull(cacheDir, "context.cacheDir");
        sb2.append(cacheDir.getPath());
        String str2 = Util3.a;
        sb2.append(str2);
        sb2.append("compressor");
        sb2.append(str2);
        sb.append(sb2.toString());
        Intrinsics3.checkParameterIsNotNull(context, "context");
        Intrinsics3.checkParameterIsNotNull(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursorQuery = contentResolver.query(uri, new String[]{"_display_name"}, null, null, null);
        if (cursorQuery == null) {
            try {
                Intrinsics3.throwNpe();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    Closeable.closeFinally(cursorQuery, th);
                    throw th2;
                }
            }
        }
        int columnIndex = cursorQuery.getColumnIndex("_display_name");
        if (cursorQuery.moveToFirst()) {
            string = cursorQuery.getString(columnIndex);
            Intrinsics3.checkExpressionValueIsNotNull(string, "it.getString(nameIndex)");
            Closeable.closeFinally(cursorQuery, null);
        } else {
            String str3 = "IMG_" + new SimpleDateFormat("yyyyMMdd_", Locale.getDefault()).format(new Date()) + System.nanoTime();
            String type = contentResolver.getType(uri);
            if (Intrinsics3.areEqual(type, "image/jpg") || Intrinsics3.areEqual(type, "image/jpeg")) {
                string = str3 + ".jpeg";
            } else {
                if (!Intrinsics3.areEqual(type, "image/png")) {
                    throw new IllegalStateException(type + " fallback display name not supported");
                }
                string = str3 + ".png";
            }
            Closeable.closeFinally(cursorQuery, null);
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
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(context.getContentResolver().openFileDescriptor(uri, "r"));
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            try {
                IOStreams.copyTo$default(autoCloseInputStream, fileOutputStream, 0, 2, null);
                Closeable.closeFinally(fileOutputStream, null);
                Closeable.closeFinally(autoCloseInputStream, null);
                for (Constraint2 constraint2 : compression.a) {
                    while (!constraint2.b(file)) {
                        file = constraint2.a(file);
                    }
                }
                return file;
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    Closeable.closeFinally(fileOutputStream, th3);
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                Closeable.closeFinally(autoCloseInputStream, th5);
                throw th6;
            }
        }
    }
}
