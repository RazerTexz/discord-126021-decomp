package b.b.a.d;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build$VERSION;
import android.provider.MediaStore$Images$Thumbnails;
import android.view.View;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import b.f.g.e.r;
import com.discord.utilities.color.ColorCompat;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lytefast.flexinput.R$b;
import com.lytefast.flexinput.model.Media;
import kotlinx.coroutines.CoroutineDispatcher;
import s.a.a.n;
import s.a.k0;
import s.a.x0;

/* JADX INFO: compiled from: ThumbnailViewHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i extends RecyclerView$ViewHolder {
    public static int j;
    public static int k;
    public static ColorDrawable l;
    public static final i$a m = new i$a(null);
    public i$b n;
    public i$c o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(View view) {
        super(view);
        d0.z.d.m.checkNotNullParameter(view, "itemView");
        if (Build$VERSION.SDK_INT >= 29) {
            Context context = view.getContext();
            d0.z.d.m.checkNotNullExpressionValue(context, "itemView.context");
            ContentResolver contentResolver = context.getContentResolver();
            d0.z.d.m.checkNotNullExpressionValue(contentResolver, "itemView.context.contentResolver");
            this.n = new i$b(contentResolver);
            return;
        }
        Context context2 = view.getContext();
        d0.z.d.m.checkNotNullExpressionValue(context2, "itemView.context");
        ContentResolver contentResolver2 = context2.getContentResolver();
        d0.z.d.m.checkNotNullExpressionValue(contentResolver2, "itemView.context.contentResolver");
        this.o = new i$c(contentResolver2);
    }

    public abstract SimpleDraweeView a();

    public final void b() {
        i$b i_b;
        if (!(Build$VERSION.SDK_INT >= 29) || (i_b = this.n) == null) {
            return;
        }
        i_b.a();
    }

    public final void c(Media media, Integer num, Integer num2) {
        if (l == null) {
            View view = this.itemView;
            d0.z.d.m.checkNotNullExpressionValue(view, "itemView");
            l = new ColorDrawable(ColorCompat.getThemedColor(view, R$b.flexInputDialogBackground));
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
        if (Build$VERSION.SDK_INT >= 29) {
            GenericDraweeHierarchy hierarchy = a().getHierarchy();
            ColorDrawable colorDrawable = l;
            ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.a;
            hierarchy.q(colorDrawable, r.l);
            i$b i_b = this.n;
            if (i_b != null) {
                Uri uri2 = media.getUri();
                i$d i_d = new i$d(this);
                d0.z.d.m.checkNotNullParameter(uri2, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
                d0.z.d.m.checkNotNullParameter(i_d, "onGenerate");
                i_b.a();
                x0 x0Var = x0.j;
                CoroutineDispatcher coroutineDispatcher = k0.a;
                i_b.a = b.i.a.f.e.o.f.H0(x0Var, n.f3830b, null, new j(i_b, uri2, i_d, null), 2, null);
                return;
            }
            return;
        }
        i$c i_c = this.o;
        if (i_c != null) {
            long id2 = media.getId();
            Uri uri3 = media.getUri();
            d0.z.d.m.checkNotNullParameter(uri3, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
            m mVar = new m(id2);
            Cursor cursorQuery = i_c.a.query(MediaStore$Images$Thumbnails.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "image_id = ? AND KIND = ?", new String[]{String.valueOf(id2), String.valueOf(1)}, null);
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                ContentResolver contentResolver = i_c.a;
                d0.z.d.m.checkNotNullParameter(contentResolver, "contentResolver");
                AsyncTask.execute(new l(mVar, contentResolver));
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } else {
                try {
                    uri3 = ContentUris.withAppendedId(MediaStore$Images$Thumbnails.EXTERNAL_CONTENT_URI, cursorQuery.getLong(0));
                    d0.y.b.closeFinally(cursorQuery, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        d0.y.b.closeFinally(cursorQuery, th);
                        throw th2;
                    }
                }
            }
            uri = uri3;
        }
        a().setImageURI(uri, a().getContext());
    }
}
