package p007b.p076b.p077a.p079d;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.CancellationSignal;
import android.provider.MediaStore;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.utilities.color.ColorCompat;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lytefast.flexinput.C11170R;
import com.lytefast.flexinput.model.Media;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;
import p007b.p109f.p132g.p142e.C1784r;
import p007b.p109f.p132g.p142e.C1785s;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p591y.C12201b;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.C13124k0;
import p659s.p660a.C13163x0;
import p659s.p660a.p661a.C13031n;

/* JADX INFO: renamed from: b.b.a.d.i */
/* JADX INFO: compiled from: ThumbnailViewHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1439i extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: j */
    public static int f2159j;

    /* JADX INFO: renamed from: k */
    public static int f2160k;

    /* JADX INFO: renamed from: l */
    public static ColorDrawable f2161l;

    /* JADX INFO: renamed from: m */
    public static final a f2162m = new a(null);

    /* JADX INFO: renamed from: n */
    public b f2163n;

    /* JADX INFO: renamed from: o */
    public c f2164o;

    /* JADX INFO: renamed from: b.b.a.d.i$a */
    /* JADX INFO: compiled from: ThumbnailViewHolder.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public static final boolean m406a(a aVar) {
            return Build.VERSION.SDK_INT >= 29;
        }
    }

    /* JADX INFO: renamed from: b.b.a.d.i$b */
    /* JADX INFO: compiled from: ThumbnailViewHolder.kt */
    @RequiresApi(29)
    public static final class b {

        /* JADX INFO: renamed from: a */
        public Job f2165a;

        /* JADX INFO: renamed from: b */
        public CancellationSignal f2166b;

        /* JADX INFO: renamed from: c */
        public Bitmap f2167c;

        /* JADX INFO: renamed from: d */
        public final ContentResolver f2168d;

        public b(ContentResolver contentResolver) {
            C12238m.checkNotNullParameter(contentResolver, "contentResolver");
            this.f2168d = contentResolver;
        }

        /* JADX INFO: renamed from: a */
        public final void m407a() {
            if (a.m406a(AbstractC1439i.f2162m)) {
                Job job = this.f2165a;
                if (job != null) {
                    C3404f.m4343t(job, null, 1, null);
                }
                CancellationSignal cancellationSignal = this.f2166b;
                if (cancellationSignal != null) {
                    cancellationSignal.cancel();
                }
            }
            Bitmap bitmap = this.f2167c;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.f2167c = null;
        }
    }

    /* JADX INFO: renamed from: b.b.a.d.i$c */
    /* JADX INFO: compiled from: ThumbnailViewHolder.kt */
    public static final class c {

        /* JADX INFO: renamed from: a */
        public final ContentResolver f2169a;

        public c(ContentResolver contentResolver) {
            C12238m.checkNotNullParameter(contentResolver, "contentResolver");
            this.f2169a = contentResolver;
        }
    }

    /* JADX INFO: renamed from: b.b.a.d.i$d */
    /* JADX INFO: compiled from: ThumbnailViewHolder.kt */
    public static final class d extends AbstractC12240o implements Function1<Bitmap, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Bitmap bitmap) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(AbstractC1439i.this.mo401a().getResources(), bitmap);
            GenericDraweeHierarchy hierarchy = AbstractC1439i.this.mo401a().getHierarchy();
            ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.f19495a;
            ScalingUtils$ScaleType scalingUtils$ScaleType2 = C1785s.f3443l;
            hierarchy.m8679o(1, bitmapDrawable);
            hierarchy.m8676l(1).m1120r(scalingUtils$ScaleType2);
            return Unit.f27425a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC1439i(View view) {
        super(view);
        C12238m.checkNotNullParameter(view, "itemView");
        if (Build.VERSION.SDK_INT >= 29) {
            Context context = view.getContext();
            C12238m.checkNotNullExpressionValue(context, "itemView.context");
            ContentResolver contentResolver = context.getContentResolver();
            C12238m.checkNotNullExpressionValue(contentResolver, "itemView.context.contentResolver");
            this.f2163n = new b(contentResolver);
            return;
        }
        Context context2 = view.getContext();
        C12238m.checkNotNullExpressionValue(context2, "itemView.context");
        ContentResolver contentResolver2 = context2.getContentResolver();
        C12238m.checkNotNullExpressionValue(contentResolver2, "itemView.context.contentResolver");
        this.f2164o = new c(contentResolver2);
    }

    /* JADX INFO: renamed from: a */
    public abstract SimpleDraweeView mo401a();

    /* JADX INFO: renamed from: b */
    public final void m404b() {
        b bVar;
        if (!(Build.VERSION.SDK_INT >= 29) || (bVar = this.f2163n) == null) {
            return;
        }
        bVar.m407a();
    }

    /* JADX INFO: renamed from: c */
    public final void m405c(Media media, Integer num, Integer num2) throws IOException {
        if (f2161l == null) {
            View view = this.itemView;
            C12238m.checkNotNullExpressionValue(view, "itemView");
            f2161l = new ColorDrawable(ColorCompat.getThemedColor(view, C11170R.b.flexInputDialogBackground));
        }
        if (num != null) {
            f2159j = num.intValue();
        }
        if (num2 != null) {
            f2160k = num2.intValue();
        }
        if (media == null) {
            return;
        }
        Uri uri = null;
        if (Build.VERSION.SDK_INT >= 29) {
            GenericDraweeHierarchy hierarchy = mo401a().getHierarchy();
            ColorDrawable colorDrawable = f2161l;
            ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.f19495a;
            hierarchy.m8681q(colorDrawable, C1784r.f3442l);
            b bVar = this.f2163n;
            if (bVar != null) {
                Uri uri2 = media.getUri();
                d dVar = new d();
                C12238m.checkNotNullParameter(uri2, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
                C12238m.checkNotNullParameter(dVar, "onGenerate");
                bVar.m407a();
                C13163x0 c13163x0 = C13163x0.f27919j;
                CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
                bVar.f2165a = C3404f.m4211H0(c13163x0, C13031n.f27700b, null, new C1440j(bVar, uri2, dVar, null), 2, null);
                return;
            }
            return;
        }
        c cVar = this.f2164o;
        if (cVar != null) {
            long id2 = media.getId();
            Uri uri3 = media.getUri();
            C12238m.checkNotNullParameter(uri3, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            C1443m c1443m = new C1443m(id2);
            Cursor cursorQuery = cVar.f2169a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "image_id = ? AND KIND = ?", new String[]{String.valueOf(id2), String.valueOf(1)}, null);
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                ContentResolver contentResolver = cVar.f2169a;
                C12238m.checkNotNullParameter(contentResolver, "contentResolver");
                AsyncTask.execute(new RunnableC1442l(c1443m, contentResolver));
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } else {
                try {
                    uri3 = ContentUris.withAppendedId(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, cursorQuery.getLong(0));
                    C12201b.closeFinally(cursorQuery, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        C12201b.closeFinally(cursorQuery, th);
                        throw th2;
                    }
                }
            }
            uri = uri3;
        }
        mo401a().setImageURI(uri, mo401a().getContext());
    }
}
