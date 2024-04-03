package de.tadris.fitness.data;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ExportTargetDao_Impl implements ExportTargetDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ExportTargetConfiguration> __insertionAdapterOfExportTargetConfiguration;

  private final EntityDeletionOrUpdateAdapter<ExportTargetConfiguration> __deletionAdapterOfExportTargetConfiguration;

  public ExportTargetDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfExportTargetConfiguration = new EntityInsertionAdapter<ExportTargetConfiguration>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `export_target_config` (`id`,`source`,`type`,`data`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ExportTargetConfiguration value) {
        stmt.bindLong(1, value.id);
        if (value.source == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.source);
        }
        if (value.type == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.type);
        }
        if (value.data == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.data);
        }
      }
    };
    this.__deletionAdapterOfExportTargetConfiguration = new EntityDeletionOrUpdateAdapter<ExportTargetConfiguration>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `export_target_config` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ExportTargetConfiguration value) {
        stmt.bindLong(1, value.id);
      }
    };
  }

  @Override
  public void insert(final ExportTargetConfiguration configuration) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfExportTargetConfiguration.insert(configuration);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final ExportTargetConfiguration configuration) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfExportTargetConfiguration.handle(configuration);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public ExportTargetConfiguration findById(final long id) {
    final String _sql = "SELECT * FROM export_target_config WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final ExportTargetConfiguration _result;
      if(_cursor.moveToFirst()) {
        _result = new ExportTargetConfiguration();
        _result.id = _cursor.getLong(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfSource)) {
          _result.source = null;
        } else {
          _result.source = _cursor.getString(_cursorIndexOfSource);
        }
        if (_cursor.isNull(_cursorIndexOfType)) {
          _result.type = null;
        } else {
          _result.type = _cursor.getString(_cursorIndexOfType);
        }
        if (_cursor.isNull(_cursorIndexOfData)) {
          _result.data = null;
        } else {
          _result.data = _cursor.getString(_cursorIndexOfData);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public ExportTargetConfiguration[] findAllFor(final String source) {
    final String _sql = "SELECT * FROM export_target_config WHERE source = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (source == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, source);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final ExportTargetConfiguration[] _result = new ExportTargetConfiguration[_cursor.getCount()];
      int _index = 0;
      while(_cursor.moveToNext()) {
        final ExportTargetConfiguration _item;
        _item = new ExportTargetConfiguration();
        _item.id = _cursor.getLong(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfSource)) {
          _item.source = null;
        } else {
          _item.source = _cursor.getString(_cursorIndexOfSource);
        }
        if (_cursor.isNull(_cursorIndexOfType)) {
          _item.type = null;
        } else {
          _item.type = _cursor.getString(_cursorIndexOfType);
        }
        if (_cursor.isNull(_cursorIndexOfData)) {
          _item.data = null;
        } else {
          _item.data = _cursor.getString(_cursorIndexOfData);
        }
        _result[_index] = _item;
        _index ++;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
