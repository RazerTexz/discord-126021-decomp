package b.b.a.d;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Build$VERSION;

/* JADX INFO: compiled from: MediaCursorAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$b extends AsyncQueryHandler {
    public final /* synthetic */ h a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$b(h hVar, ContentResolver contentResolver) {
        super(contentResolver);
        this.a = hVar;
    }

    @Override // android.content.AsyncQueryHandler
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        d0.z.d.m.checkNotNullParameter(obj, "cookie");
        if (cursor == null) {
            return;
        }
        h hVar = this.a;
        hVar.c = cursor.getColumnIndex("_id");
        hVar.d = cursor.getColumnIndex("_data");
        hVar.e = cursor.getColumnIndex("_display_name");
        hVar.f = cursor.getColumnIndex("media_type");
        if (Build$VERSION.SDK_INT >= 29) {
            hVar.g = Integer.valueOf(cursor.getColumnIndex("duration"));
        }
        hVar.f319b = cursor;
        this.a.notifyDataSetChanged();
    }
}
