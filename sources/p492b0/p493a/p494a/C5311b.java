package p492b0.p493a.p494a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.core.app.NotificationCompat;
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
import p492b0.p493a.p494a.p495e.C5314a;
import p492b0.p493a.p494a.p495e.InterfaceC5315b;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p591y.C12200a;
import p507d0.p591y.C12201b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b0.a.a.b */
/* JADX INFO: compiled from: Compressor.kt */
/* JADX INFO: loaded from: classes3.dex */
@InterfaceC12188e(m10084c = "id.zelory.compressor.Compressor$compress$6", m10085f = "Compressor.kt", m10086l = {}, m10087m = "invokeSuspend")
public final class C5311b extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    public final /* synthetic */ Function1 $compressionPatch;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ Uri $imageFileUri;
    public int label;

    /* JADX INFO: renamed from: p$ */
    private CoroutineScope f14502p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5311b(Function1 function1, Context context, Uri uri, Continuation continuation) {
        super(2, continuation);
        this.$compressionPatch = function1;
        this.$context = context;
        this.$imageFileUri = uri;
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C12238m.checkParameterIsNotNull(continuation, "completion");
        C5311b c5311b = new C5311b(this.$compressionPatch, this.$context, this.$imageFileUri, continuation);
        c5311b.f14502p$ = (CoroutineScope) obj;
        return c5311b;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super File> continuation) {
        Continuation<? super File> continuation2 = continuation;
        C12238m.checkParameterIsNotNull(continuation2, "completion");
        C5311b c5311b = new C5311b(this.$compressionPatch, this.$context, this.$imageFileUri, continuation2);
        c5311b.f14502p$ = coroutineScope;
        return c5311b.invokeSuspend(Unit.f27425a);
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public final Object invokeSuspend(Object obj) throws IOException {
        String string;
        C12183c.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C12113l.throwOnFailure(obj);
        C5314a c5314a = new C5314a();
        this.$compressionPatch.invoke(c5314a);
        Context context = this.$context;
        Uri uri = this.$imageFileUri;
        String str = C5313d.f14504a;
        C12238m.checkParameterIsNotNull(context, "context");
        C12238m.checkParameterIsNotNull(uri, "srcFileUri");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        File cacheDir = context.getCacheDir();
        C12238m.checkExpressionValueIsNotNull(cacheDir, "context.cacheDir");
        sb2.append(cacheDir.getPath());
        String str2 = C5313d.f14504a;
        sb2.append(str2);
        sb2.append("compressor");
        sb2.append(str2);
        sb.append(sb2.toString());
        C12238m.checkParameterIsNotNull(context, "context");
        C12238m.checkParameterIsNotNull(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursorQuery = contentResolver.query(uri, new String[]{"_display_name"}, null, null, null);
        if (cursorQuery == null) {
            try {
                C12238m.throwNpe();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    C12201b.closeFinally(cursorQuery, th);
                    throw th2;
                }
            }
        }
        int columnIndex = cursorQuery.getColumnIndex("_display_name");
        if (cursorQuery.moveToFirst()) {
            string = cursorQuery.getString(columnIndex);
            C12238m.checkExpressionValueIsNotNull(string, "it.getString(nameIndex)");
            C12201b.closeFinally(cursorQuery, null);
        } else {
            String str3 = "IMG_" + new SimpleDateFormat("yyyyMMdd_", Locale.getDefault()).format(new Date()) + System.nanoTime();
            String type = contentResolver.getType(uri);
            if (C12238m.areEqual(type, "image/jpg") || C12238m.areEqual(type, "image/jpeg")) {
                string = str3 + ".jpeg";
            } else {
                if (!C12238m.areEqual(type, "image/png")) {
                    throw new IllegalStateException(type + " fallback display name not supported");
                }
                string = str3 + ".png";
            }
            C12201b.closeFinally(cursorQuery, null);
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
                C12200a.copyTo$default(autoCloseInputStream, fileOutputStream, 0, 2, null);
                C12201b.closeFinally(fileOutputStream, null);
                C12201b.closeFinally(autoCloseInputStream, null);
                for (InterfaceC5315b interfaceC5315b : c5314a.f14505a) {
                    while (!interfaceC5315b.mo7490b(file)) {
                        file = interfaceC5315b.mo7489a(file);
                    }
                }
                return file;
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    C12201b.closeFinally(fileOutputStream, th3);
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                C12201b.closeFinally(autoCloseInputStream, th5);
                throw th6;
            }
        }
    }
}
