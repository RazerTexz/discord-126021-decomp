package b.b.a.d;

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
import b.f.g.e.r;
import b.f.g.e.s;
import com.discord.utilities.color.ColorCompat;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lytefast.flexinput.R;
import com.lytefast.flexinput.model.Media;
import d0.y.Closeable;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;
import s.a.CoroutineScope2;
import s.a.Dispatchers;
import s.a.a.MainDispatchers;

/* JADX INFO: renamed from: b.b.a.d.i, reason: use source file name */
/* JADX INFO: compiled from: ThumbnailViewHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ThumbnailViewHolder extends RecyclerView.ViewHolder {
    public static int j;
    public static int k;
    public static ColorDrawable l;
    public static final a m = new a(null);
    public b n;
    public c o;

    /* JADX INFO: renamed from: b.b.a.d.i$a */
    /* JADX INFO: compiled from: ThumbnailViewHolder.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final boolean a(a aVar) {
            return Build.VERSION.SDK_INT >= 29;
        }
    }

    /* JADX INFO: renamed from: b.b.a.d.i$b */
    /* JADX INFO: compiled from: ThumbnailViewHolder.kt */
    @RequiresApi(29)
    public static final class b {
        public Job a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CancellationSignal f321b;
        public Bitmap c;
        public final ContentResolver d;

        public b(ContentResolver contentResolver) {
            Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
            this.d = contentResolver;
        }

        public final void a() {
            if (a.a(ThumbnailViewHolder.m)) {
                Job job = this.a;
                if (job != null) {
                    b.i.a.f.e.o.f.t(job, null, 1, null);
                }
                CancellationSignal cancellationSignal = this.f321b;
                if (cancellationSignal != null) {
                    cancellationSignal.cancel();
                }
            }
            Bitmap bitmap = this.c;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.c = null;
        }
    }

    /* JADX INFO: renamed from: b.b.a.d.i$c */
    /* JADX INFO: compiled from: ThumbnailViewHolder.kt */
    public static final class c {
        public final ContentResolver a;

        public c(ContentResolver contentResolver) {
            Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
            this.a = contentResolver;
        }
    }

    /* JADX INFO: renamed from: b.b.a.d.i$d */
    /* JADX INFO: compiled from: ThumbnailViewHolder.kt */
    public static final class d extends Lambda implements Function1<Bitmap, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Bitmap bitmap) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(ThumbnailViewHolder.this.a().getResources(), bitmap);
            GenericDraweeHierarchy hierarchy = ThumbnailViewHolder.this.a().getHierarchy();
            ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.a;
            ScalingUtils$ScaleType scalingUtils$ScaleType2 = s.l;
            hierarchy.o(1, bitmapDrawable);
            hierarchy.l(1).r(scalingUtils$ScaleType2);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThumbnailViewHolder(View view) {
        super(view);
        Intrinsics3.checkNotNullParameter(view, "itemView");
        if (Build.VERSION.SDK_INT >= 29) {
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "itemView.context");
            ContentResolver contentResolver = context.getContentResolver();
            Intrinsics3.checkNotNullExpressionValue(contentResolver, "itemView.context.contentResolver");
            this.n = new b(contentResolver);
            return;
        }
        Context context2 = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "itemView.context");
        ContentResolver contentResolver2 = context2.getContentResolver();
        Intrinsics3.checkNotNullExpressionValue(contentResolver2, "itemView.context.contentResolver");
        this.o = new c(contentResolver2);
    }

    public abstract SimpleDraweeView a();

    public final void b() {
        b bVar;
        if (!(Build.VERSION.SDK_INT >= 29) || (bVar = this.n) == null) {
            return;
        }
        bVar.a();
    }

    public final void c(Media media, Integer num, Integer num2) throws IOException {
        if (l == null) {
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            l = new ColorDrawable(ColorCompat.getThemedColor(view, R.b.flexInputDialogBackground));
        }
        if (num != null) {
            j = num.intValue();
        }
        if (num2 != null) {
            k = num2.intValue();
        }
        if (media == null) {
            return;
        }
        Uri uri = null;
        if (Build.VERSION.SDK_INT >= 29) {
            GenericDraweeHierarchy hierarchy = a().getHierarchy();
            ColorDrawable colorDrawable = l;
            ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.a;
            hierarchy.q(colorDrawable, r.l);
            b bVar = this.n;
            if (bVar != null) {
                Uri uri2 = media.getUri();
                d dVar = new d();
                Intrinsics3.checkNotNullParameter(uri2, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
                Intrinsics3.checkNotNullParameter(dVar, "onGenerate");
                bVar.a();
                CoroutineScope2 coroutineScope2 = CoroutineScope2.j;
                CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
                bVar.a = b.i.a.f.e.o.f.H0(coroutineScope2, MainDispatchers.f3830b, null, new ThumbnailViewHolder2(bVar, uri2, dVar, null), 2, null);
                return;
            }
            return;
        }
        c cVar = this.o;
        if (cVar != null) {
            long id2 = media.getId();
            Uri uri3 = media.getUri();
            Intrinsics3.checkNotNullParameter(uri3, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            ThumbnailViewHolder5 thumbnailViewHolder5 = new ThumbnailViewHolder5(id2);
            Cursor cursorQuery = cVar.a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "image_id = ? AND KIND = ?", new String[]{String.valueOf(id2), String.valueOf(1)}, null);
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                ContentResolver contentResolver = cVar.a;
                Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
                AsyncTask.execute(new ThumbnailViewHolder4(thumbnailViewHolder5, contentResolver));
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } else {
                try {
                    uri3 = ContentUris.withAppendedId(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, cursorQuery.getLong(0));
                    Closeable.closeFinally(cursorQuery, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        Closeable.closeFinally(cursorQuery, th);
                        throw th2;
                    }
                }
            }
            uri = uri3;
        }
        a().setImageURI(uri, a().getContext());
    }
}
