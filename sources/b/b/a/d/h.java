package b.b.a.d;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build$VERSION;
import android.provider.MediaStore$Files;
import android.provider.MediaStore$Images$Media;
import android.provider.MediaStore$Video$Media;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.utilities.time.TimeUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lytefast.flexinput.R$f;
import com.lytefast.flexinput.R$g;
import com.lytefast.flexinput.R$h;
import com.lytefast.flexinput.model.Media;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import com.lytefast.flexinput.utils.SelectionCoordinator$a;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: MediaCursorAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends RecyclerView$Adapter<h$a> {
    public final SelectionCoordinator<?, Media> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Cursor f319b;
    public int c;
    public int d;
    public int e;
    public int f;
    public Integer g;
    public final int h;
    public final int i;

    public h(SelectionCoordinator<?, Media> selectionCoordinator, int i, int i2) {
        d0.z.d.m.checkNotNullParameter(selectionCoordinator, "selectionCoordinator");
        this.h = i;
        this.i = i2;
        Objects.requireNonNull(selectionCoordinator);
        d0.z.d.m.checkNotNullParameter(this, "adapter");
        selectionCoordinator.adapter = this;
        this.a = selectionCoordinator;
        setHasStableIds(true);
    }

    public final Media a(int i) {
        String str;
        Cursor cursor = this.f319b;
        Media media = null;
        lValueOf = null;
        Long lValueOf = null;
        if (cursor != null) {
            cursor.moveToPosition(i);
            long j = cursor.getLong(this.c);
            boolean z2 = cursor.getInt(this.f) == 3;
            Uri uriWithAppendedPath = z2 ? Uri.withAppendedPath(MediaStore$Video$Media.EXTERNAL_CONTENT_URI, String.valueOf(j)) : Uri.withAppendedPath(MediaStore$Images$Media.EXTERNAL_CONTENT_URI, String.valueOf(j));
            String str2 = z2 ? "vid" : "img";
            Integer num = this.g;
            if (z2 && num != null) {
                lValueOf = Long.valueOf(cursor.getLong(num.intValue()));
            }
            Long l = lValueOf;
            d0.z.d.m.checkNotNullExpressionValue(uriWithAppendedPath, "fileUri");
            String string = cursor.getString(this.e);
            if (string != null) {
                str = string;
            } else {
                str = str2 + '-' + j;
            }
            media = new Media(j, uriWithAppendedPath, str, cursor.getString(this.d), z2, l);
        }
        return media;
    }

    public final void b(ContentResolver contentResolver) {
        d0.z.d.m.checkNotNullParameter(contentResolver, "contentResolver");
        int i = Build$VERSION.SDK_INT;
        String str = i >= 29 ? "media_type = 1 OR media_type = 3" : "media_type = 1";
        new h$b(this, contentResolver).startQuery(1, this, MediaStore$Files.getContentUri("external"), i >= 29 ? new String[]{"_id", "_data", "_display_name", "media_type", "duration"} : new String[]{"_id", "_data", "_display_name", "media_type"}, str, null, "date_added DESC");
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        Cursor cursor = this.f319b;
        if (cursor != null) {
            return cursor.getCount();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public long getItemId(int i) {
        Media mediaA = a(i);
        if (mediaA != null) {
            return mediaA.getId();
        }
        return -1L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        d0.z.d.m.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        Context context = recyclerView.getContext();
        d0.z.d.m.checkNotNullExpressionValue(context, "recyclerView.context");
        ContentResolver contentResolver = context.getContentResolver();
        d0.z.d.m.checkNotNullExpressionValue(contentResolver, "recyclerView.context.contentResolver");
        b(contentResolver);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        Long l;
        h$a h_a = (h$a) recyclerView$ViewHolder;
        d0.z.d.m.checkNotNullParameter(h_a, "holder");
        Media mediaA = a(i);
        h_a.p = mediaA;
        FrameLayout frameLayout = h_a.f320s.a;
        d0.z.d.m.checkNotNullExpressionValue(frameLayout, "binding.root");
        Context context = frameLayout.getContext();
        if (mediaA != null) {
            h_a.d(h_a.t.a.a(mediaA, h_a.getAdapterPosition()), false);
        }
        h_a.c(mediaA, Integer.valueOf(h_a.t.h), Integer.valueOf(h_a.t.i));
        boolean z2 = mediaA != null && mediaA.j;
        TextView textView = h_a.f320s.e;
        d0.z.d.m.checkNotNullExpressionValue(textView, "binding.itemVideoIndicator");
        textView.setVisibility(z2 ? 0 : 8);
        if (z2) {
            TextView textView2 = h_a.f320s.e;
            d0.z.d.m.checkNotNullExpressionValue(textView2, "binding.itemVideoIndicator");
            Drawable background = textView2.getBackground();
            d0.z.d.m.checkNotNullExpressionValue(background, "binding.itemVideoIndicator.background");
            background.setAlpha(Opcodes.LAND);
            long jLongValue = (mediaA == null || (l = mediaA.k) == null) ? 0L : l.longValue();
            TextView textView3 = h_a.f320s.e;
            d0.z.d.m.checkNotNullExpressionValue(textView3, "binding.itemVideoIndicator");
            textView3.setText(jLongValue > 0 ? TimeUtils.toFriendlyStringSimple$default(TimeUtils.INSTANCE, jLongValue, null, null, 6, null) : context.getString(R$h.video));
        }
        SimpleDraweeView simpleDraweeView = h_a.f320s.c;
        d0.z.d.m.checkNotNullExpressionValue(simpleDraweeView, "binding.contentIv");
        simpleDraweeView.setContentDescription(context.getString(z2 ? R$h.video : R$h.image));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        d0.z.d.m.checkNotNullParameter(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$g.view_grid_image, viewGroup, false);
        int i2 = R$f.content_container;
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(i2);
        if (frameLayout != null) {
            i2 = R$f.content_iv;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(i2);
            if (simpleDraweeView != null) {
                i2 = R$f.item_check_indicator;
                SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) viewInflate.findViewById(i2);
                if (simpleDraweeView2 != null) {
                    i2 = R$f.item_video_indicator;
                    TextView textView = (TextView) viewInflate.findViewById(i2);
                    if (textView != null) {
                        b.b.a.e.c cVar = new b.b.a.e.c((FrameLayout) viewInflate, frameLayout, simpleDraweeView, simpleDraweeView2, textView);
                        d0.z.d.m.checkNotNullExpressionValue(cVar, "ViewGridImageBinding.inf….context), parent, false)");
                        return new h$a(this, cVar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        d0.z.d.m.checkNotNullParameter(recyclerView, "recyclerView");
        Cursor cursor = this.f319b;
        if (cursor != null) {
            cursor.close();
        }
        super.onDetachedFromRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void onViewRecycled(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        h$a h_a = (h$a) recyclerView$ViewHolder;
        d0.z.d.m.checkNotNullParameter(h_a, "holder");
        super.onViewRecycled(h_a);
        h_a.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i, List list) {
        Object next;
        h$a h_a = (h$a) recyclerView$ViewHolder;
        d0.z.d.m.checkNotNullParameter(h_a, "holder");
        d0.z.d.m.checkNotNullParameter(list, "payloads");
        Iterator it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(next instanceof SelectionCoordinator$a));
        if (next != null) {
            SelectionCoordinator$a selectionCoordinator$a = (SelectionCoordinator$a) (next instanceof SelectionCoordinator$a ? next : null);
            if (selectionCoordinator$a != null) {
                h_a.d(selectionCoordinator$a.f3171b, true);
                return;
            }
        }
        super.onBindViewHolder(h_a, i, list);
    }
}
