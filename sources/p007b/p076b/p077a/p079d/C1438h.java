package p007b.p076b.p077a.p079d;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.utilities.time.TimeUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lytefast.flexinput.C11170R;
import com.lytefast.flexinput.model.Media;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.objectweb.asm.Opcodes;
import p007b.p076b.p077a.p080e.C1446c;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.b.a.d.h */
/* JADX INFO: compiled from: MediaCursorAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C1438h extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: a */
    public final SelectionCoordinator<?, Media> f2144a;

    /* JADX INFO: renamed from: b */
    public Cursor f2145b;

    /* JADX INFO: renamed from: c */
    public int f2146c;

    /* JADX INFO: renamed from: d */
    public int f2147d;

    /* JADX INFO: renamed from: e */
    public int f2148e;

    /* JADX INFO: renamed from: f */
    public int f2149f;

    /* JADX INFO: renamed from: g */
    public Integer f2150g;

    /* JADX INFO: renamed from: h */
    public final int f2151h;

    /* JADX INFO: renamed from: i */
    public final int f2152i;

    /* JADX INFO: renamed from: b.b.a.d.h$a */
    /* JADX INFO: compiled from: MediaCursorAdapter.kt */
    public final class a extends AbstractC1439i implements View.OnClickListener {

        /* JADX INFO: renamed from: p */
        public Media f2153p;

        /* JADX INFO: renamed from: q */
        public final AnimatorSet f2154q;

        /* JADX INFO: renamed from: r */
        public final AnimatorSet f2155r;

        /* JADX INFO: renamed from: s */
        public final C1446c f2156s;

        /* JADX INFO: renamed from: t */
        public final /* synthetic */ C1438h f2157t;

        /* JADX INFO: renamed from: b.b.a.d.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MediaCursorAdapter.kt */
        public static final class C13219a extends AbstractC12240o implements Function1<AnimatorSet, Unit> {
            public final /* synthetic */ boolean $isAnimationRequested;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C13219a(boolean z2) {
                super(1);
                this.$isAnimationRequested = z2;
            }

            /* JADX INFO: renamed from: a */
            public final void m403a(AnimatorSet animatorSet) {
                C12238m.checkNotNullParameter(animatorSet, "animation");
                animatorSet.start();
                if (this.$isAnimationRequested) {
                    return;
                }
                animatorSet.end();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AnimatorSet animatorSet) {
                m403a(animatorSet);
                return Unit.f27425a;
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public a(C1438h c1438h, C1446c c1446c) {
            C12238m.checkNotNullParameter(c1446c, "binding");
            this.f2157t = c1438h;
            FrameLayout frameLayout = c1446c.f2194a;
            C12238m.checkNotNullExpressionValue(frameLayout, "binding.root");
            super(frameLayout);
            this.f2156s = c1446c;
            c1446c.f2194a.setOnClickListener(this);
            FrameLayout frameLayout2 = c1446c.f2194a;
            C12238m.checkNotNullExpressionValue(frameLayout2, "binding.root");
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(frameLayout2.getContext(), C11170R.a.selection_shrink);
            Objects.requireNonNull(animatorLoadAnimator, "null cannot be cast to non-null type android.animation.AnimatorSet");
            AnimatorSet animatorSet = (AnimatorSet) animatorLoadAnimator;
            this.f2154q = animatorSet;
            animatorSet.setTarget(c1446c.f2195b);
            FrameLayout frameLayout3 = c1446c.f2194a;
            C12238m.checkNotNullExpressionValue(frameLayout3, "binding.root");
            Animator animatorLoadAnimator2 = AnimatorInflater.loadAnimator(frameLayout3.getContext(), C11170R.a.selection_grow);
            Objects.requireNonNull(animatorLoadAnimator2, "null cannot be cast to non-null type android.animation.AnimatorSet");
            AnimatorSet animatorSet2 = (AnimatorSet) animatorLoadAnimator2;
            this.f2155r = animatorSet2;
            animatorSet2.setTarget(c1446c.f2195b);
        }

        @Override // p007b.p076b.p077a.p079d.AbstractC1439i
        /* JADX INFO: renamed from: a */
        public SimpleDraweeView mo401a() {
            SimpleDraweeView simpleDraweeView = this.f2156s.f2196c;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.contentIv");
            return simpleDraweeView;
        }

        /* JADX INFO: renamed from: d */
        public final void m402d(boolean z2, boolean z3) {
            FrameLayout frameLayout = this.f2156s.f2194a;
            C12238m.checkNotNullExpressionValue(frameLayout, "binding.root");
            frameLayout.setSelected(z2);
            C13219a c13219a = new C13219a(z3);
            if (z2) {
                SimpleDraweeView simpleDraweeView = this.f2156s.f2197d;
                C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.itemCheckIndicator");
                simpleDraweeView.setVisibility(0);
                FrameLayout frameLayout2 = this.f2156s.f2195b;
                C12238m.checkNotNullExpressionValue(frameLayout2, "binding.contentContainer");
                if (frameLayout2.getScaleX() == 1.0f) {
                    c13219a.m403a(this.f2154q);
                    return;
                }
                return;
            }
            SimpleDraweeView simpleDraweeView2 = this.f2156s.f2197d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemCheckIndicator");
            simpleDraweeView2.setVisibility(8);
            FrameLayout frameLayout3 = this.f2156s.f2195b;
            C12238m.checkNotNullExpressionValue(frameLayout3, "binding.contentContainer");
            if (frameLayout3.getScaleX() != 1.0f) {
                c13219a.m403a(this.f2155r);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C12238m.checkNotNullParameter(view, "v");
            SelectionCoordinator<?, Media> selectionCoordinator = this.f2157t.f2144a;
            Media media = this.f2153p;
            int adapterPosition = getAdapterPosition();
            Objects.requireNonNull(selectionCoordinator);
            if (media == null || selectionCoordinator.m9301d(media)) {
                return;
            }
            selectionCoordinator.m9300c(media, adapterPosition);
        }
    }

    /* JADX INFO: renamed from: b.b.a.d.h$b */
    /* JADX INFO: compiled from: MediaCursorAdapter.kt */
    public static final class b extends AsyncQueryHandler {
        public b(ContentResolver contentResolver) {
            super(contentResolver);
        }

        @Override // android.content.AsyncQueryHandler
        public void onQueryComplete(int i, Object obj, Cursor cursor) {
            C12238m.checkNotNullParameter(obj, "cookie");
            if (cursor == null) {
                return;
            }
            C1438h c1438h = C1438h.this;
            c1438h.f2146c = cursor.getColumnIndex("_id");
            c1438h.f2147d = cursor.getColumnIndex("_data");
            c1438h.f2148e = cursor.getColumnIndex("_display_name");
            c1438h.f2149f = cursor.getColumnIndex("media_type");
            if (Build.VERSION.SDK_INT >= 29) {
                c1438h.f2150g = Integer.valueOf(cursor.getColumnIndex("duration"));
            }
            c1438h.f2145b = cursor;
            C1438h.this.notifyDataSetChanged();
        }
    }

    public C1438h(SelectionCoordinator<?, Media> selectionCoordinator, int i, int i2) {
        C12238m.checkNotNullParameter(selectionCoordinator, "selectionCoordinator");
        this.f2151h = i;
        this.f2152i = i2;
        Objects.requireNonNull(selectionCoordinator);
        C12238m.checkNotNullParameter(this, "adapter");
        selectionCoordinator.adapter = this;
        this.f2144a = selectionCoordinator;
        setHasStableIds(true);
    }

    /* JADX INFO: renamed from: a */
    public final Media m399a(int i) {
        String str;
        Cursor cursor = this.f2145b;
        Media media = null;
        lValueOf = null;
        Long lValueOf = null;
        if (cursor != null) {
            cursor.moveToPosition(i);
            long j = cursor.getLong(this.f2146c);
            boolean z2 = cursor.getInt(this.f2149f) == 3;
            Uri uriWithAppendedPath = z2 ? Uri.withAppendedPath(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, String.valueOf(j)) : Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, String.valueOf(j));
            String str2 = z2 ? "vid" : "img";
            Integer num = this.f2150g;
            if (z2 && num != null) {
                lValueOf = Long.valueOf(cursor.getLong(num.intValue()));
            }
            Long l = lValueOf;
            C12238m.checkNotNullExpressionValue(uriWithAppendedPath, "fileUri");
            String string = cursor.getString(this.f2148e);
            if (string != null) {
                str = string;
            } else {
                str = str2 + '-' + j;
            }
            media = new Media(j, uriWithAppendedPath, str, cursor.getString(this.f2147d), z2, l);
        }
        return media;
    }

    /* JADX INFO: renamed from: b */
    public final void m400b(ContentResolver contentResolver) {
        C12238m.checkNotNullParameter(contentResolver, "contentResolver");
        int i = Build.VERSION.SDK_INT;
        String str = i >= 29 ? "media_type = 1 OR media_type = 3" : "media_type = 1";
        new b(contentResolver).startQuery(1, this, MediaStore.Files.getContentUri("external"), i >= 29 ? new String[]{"_id", "_data", "_display_name", "media_type", "duration"} : new String[]{"_id", "_data", "_display_name", "media_type"}, str, null, "date_added DESC");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        Cursor cursor = this.f2145b;
        if (cursor != null) {
            return cursor.getCount();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        Media mediaM399a = m399a(i);
        if (mediaM399a != null) {
            return mediaM399a.getId();
        }
        return -1L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        C12238m.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        Context context = recyclerView.getContext();
        C12238m.checkNotNullExpressionValue(context, "recyclerView.context");
        ContentResolver contentResolver = context.getContentResolver();
        C12238m.checkNotNullExpressionValue(contentResolver, "recyclerView.context.contentResolver");
        m400b(contentResolver);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) throws IOException {
        Long l;
        a aVar = (a) viewHolder;
        C12238m.checkNotNullParameter(aVar, "holder");
        Media mediaM399a = m399a(i);
        aVar.f2153p = mediaM399a;
        FrameLayout frameLayout = aVar.f2156s.f2194a;
        C12238m.checkNotNullExpressionValue(frameLayout, "binding.root");
        Context context = frameLayout.getContext();
        if (mediaM399a != null) {
            aVar.m402d(aVar.f2157t.f2144a.m9298a(mediaM399a, aVar.getAdapterPosition()), false);
        }
        aVar.m405c(mediaM399a, Integer.valueOf(aVar.f2157t.f2151h), Integer.valueOf(aVar.f2157t.f2152i));
        boolean z2 = mediaM399a != null && mediaM399a.f22082j;
        TextView textView = aVar.f2156s.f2198e;
        C12238m.checkNotNullExpressionValue(textView, "binding.itemVideoIndicator");
        textView.setVisibility(z2 ? 0 : 8);
        if (z2) {
            TextView textView2 = aVar.f2156s.f2198e;
            C12238m.checkNotNullExpressionValue(textView2, "binding.itemVideoIndicator");
            Drawable background = textView2.getBackground();
            C12238m.checkNotNullExpressionValue(background, "binding.itemVideoIndicator.background");
            background.setAlpha(Opcodes.LAND);
            long jLongValue = (mediaM399a == null || (l = mediaM399a.f22083k) == null) ? 0L : l.longValue();
            TextView textView3 = aVar.f2156s.f2198e;
            C12238m.checkNotNullExpressionValue(textView3, "binding.itemVideoIndicator");
            textView3.setText(jLongValue > 0 ? TimeUtils.toFriendlyStringSimple$default(TimeUtils.INSTANCE, jLongValue, null, null, 6, null) : context.getString(C11170R.h.video));
        }
        SimpleDraweeView simpleDraweeView = aVar.f2156s.f2196c;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.contentIv");
        simpleDraweeView.setContentDescription(context.getString(z2 ? C11170R.h.video : C11170R.h.image));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        C12238m.checkNotNullParameter(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(C11170R.g.view_grid_image, viewGroup, false);
        int i2 = C11170R.f.content_container;
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(i2);
        if (frameLayout != null) {
            i2 = C11170R.f.content_iv;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(i2);
            if (simpleDraweeView != null) {
                i2 = C11170R.f.item_check_indicator;
                SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) viewInflate.findViewById(i2);
                if (simpleDraweeView2 != null) {
                    i2 = C11170R.f.item_video_indicator;
                    TextView textView = (TextView) viewInflate.findViewById(i2);
                    if (textView != null) {
                        C1446c c1446c = new C1446c((FrameLayout) viewInflate, frameLayout, simpleDraweeView, simpleDraweeView2, textView);
                        C12238m.checkNotNullExpressionValue(c1446c, "ViewGridImageBinding.inf….context), parent, false)");
                        return new a(this, c1446c);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        C12238m.checkNotNullParameter(recyclerView, "recyclerView");
        Cursor cursor = this.f2145b;
        if (cursor != null) {
            cursor.close();
        }
        super.onDetachedFromRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        a aVar = (a) viewHolder;
        C12238m.checkNotNullParameter(aVar, "holder");
        super.onViewRecycled(aVar);
        aVar.m404b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        Object next;
        a aVar = (a) viewHolder;
        C12238m.checkNotNullParameter(aVar, "holder");
        C12238m.checkNotNullParameter(list, "payloads");
        Iterator it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(next instanceof SelectionCoordinator.C11192a));
        if (next != null) {
            SelectionCoordinator.C11192a c11192a = (SelectionCoordinator.C11192a) (next instanceof SelectionCoordinator.C11192a ? next : null);
            if (c11192a != null) {
                aVar.m402d(c11192a.f22090b, true);
                return;
            }
        }
        super.onBindViewHolder(aVar, i, list);
    }
}
