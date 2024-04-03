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
public final class IndoorWorkoutDao_Impl implements IndoorWorkoutDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<IndoorWorkout> __insertionAdapterOfIndoorWorkout;

  private final EntityInsertionAdapter<IndoorSample> __insertionAdapterOfIndoorSample;

  private final EntityDeletionOrUpdateAdapter<IndoorWorkout> __deletionAdapterOfIndoorWorkout;

  private final EntityDeletionOrUpdateAdapter<IndoorSample> __deletionAdapterOfIndoorSample;

  private final EntityDeletionOrUpdateAdapter<IndoorWorkout> __updateAdapterOfIndoorWorkout;

  private final EntityDeletionOrUpdateAdapter<IndoorSample> __updateAdapterOfIndoorSample;

  public IndoorWorkoutDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfIndoorWorkout = new EntityInsertionAdapter<IndoorWorkout>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `indoor_workout` (`repetitions`,`avgFrequency`,`maxFrequency`,`maxIntensity`,`avgIntensity`,`id`,`start`,`end`,`duration`,`pauseDuration`,`comment`,`workoutType`,`avg_heart_rate`,`max_heart_rate`,`calorie`,`edited`,`interval_set_used_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, IndoorWorkout value) {
        stmt.bindLong(1, value.repetitions);
        stmt.bindDouble(2, value.avgFrequency);
        stmt.bindDouble(3, value.maxFrequency);
        stmt.bindDouble(4, value.maxIntensity);
        stmt.bindDouble(5, value.avgIntensity);
        stmt.bindLong(6, value.id);
        stmt.bindLong(7, value.start);
        stmt.bindLong(8, value.end);
        stmt.bindLong(9, value.duration);
        stmt.bindLong(10, value.pauseDuration);
        if (value.comment == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.comment);
        }
        if (value.workoutTypeId == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.workoutTypeId);
        }
        stmt.bindLong(13, value.avgHeartRate);
        stmt.bindLong(14, value.maxHeartRate);
        stmt.bindLong(15, value.calorie);
        final int _tmp = value.edited ? 1 : 0;
        stmt.bindLong(16, _tmp);
        stmt.bindLong(17, value.intervalSetUsedId);
      }
    };
    this.__insertionAdapterOfIndoorSample = new EntityInsertionAdapter<IndoorSample>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `indoor_sample` (`workout_id`,`repetitions`,`absoluteEndTime`,`intensity`,`frequency`,`id`,`absoluteTime`,`relativeTime`,`heart_rate`,`interval_triggered`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, IndoorSample value) {
        stmt.bindLong(1, value.workoutId);
        stmt.bindLong(2, value.repetitions);
        stmt.bindLong(3, value.absoluteEndTime);
        stmt.bindDouble(4, value.intensity);
        stmt.bindDouble(5, value.frequency);
        stmt.bindLong(6, value.id);
        stmt.bindLong(7, value.absoluteTime);
        stmt.bindLong(8, value.relativeTime);
        stmt.bindLong(9, value.heartRate);
        stmt.bindLong(10, value.intervalTriggered);
      }
    };
    this.__deletionAdapterOfIndoorWorkout = new EntityDeletionOrUpdateAdapter<IndoorWorkout>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `indoor_workout` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, IndoorWorkout value) {
        stmt.bindLong(1, value.id);
      }
    };
    this.__deletionAdapterOfIndoorSample = new EntityDeletionOrUpdateAdapter<IndoorSample>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `indoor_sample` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, IndoorSample value) {
        stmt.bindLong(1, value.id);
      }
    };
    this.__updateAdapterOfIndoorWorkout = new EntityDeletionOrUpdateAdapter<IndoorWorkout>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `indoor_workout` SET `repetitions` = ?,`avgFrequency` = ?,`maxFrequency` = ?,`maxIntensity` = ?,`avgIntensity` = ?,`id` = ?,`start` = ?,`end` = ?,`duration` = ?,`pauseDuration` = ?,`comment` = ?,`workoutType` = ?,`avg_heart_rate` = ?,`max_heart_rate` = ?,`calorie` = ?,`edited` = ?,`interval_set_used_id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, IndoorWorkout value) {
        stmt.bindLong(1, value.repetitions);
        stmt.bindDouble(2, value.avgFrequency);
        stmt.bindDouble(3, value.maxFrequency);
        stmt.bindDouble(4, value.maxIntensity);
        stmt.bindDouble(5, value.avgIntensity);
        stmt.bindLong(6, value.id);
        stmt.bindLong(7, value.start);
        stmt.bindLong(8, value.end);
        stmt.bindLong(9, value.duration);
        stmt.bindLong(10, value.pauseDuration);
        if (value.comment == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.comment);
        }
        if (value.workoutTypeId == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.workoutTypeId);
        }
        stmt.bindLong(13, value.avgHeartRate);
        stmt.bindLong(14, value.maxHeartRate);
        stmt.bindLong(15, value.calorie);
        final int _tmp = value.edited ? 1 : 0;
        stmt.bindLong(16, _tmp);
        stmt.bindLong(17, value.intervalSetUsedId);
        stmt.bindLong(18, value.id);
      }
    };
    this.__updateAdapterOfIndoorSample = new EntityDeletionOrUpdateAdapter<IndoorSample>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `indoor_sample` SET `workout_id` = ?,`repetitions` = ?,`absoluteEndTime` = ?,`intensity` = ?,`frequency` = ?,`id` = ?,`absoluteTime` = ?,`relativeTime` = ?,`heart_rate` = ?,`interval_triggered` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, IndoorSample value) {
        stmt.bindLong(1, value.workoutId);
        stmt.bindLong(2, value.repetitions);
        stmt.bindLong(3, value.absoluteEndTime);
        stmt.bindDouble(4, value.intensity);
        stmt.bindDouble(5, value.frequency);
        stmt.bindLong(6, value.id);
        stmt.bindLong(7, value.absoluteTime);
        stmt.bindLong(8, value.relativeTime);
        stmt.bindLong(9, value.heartRate);
        stmt.bindLong(10, value.intervalTriggered);
        stmt.bindLong(11, value.id);
      }
    };
  }

  @Override
  public void insertWorkoutAndSamples(final IndoorWorkout workout, final IndoorSample[] samples) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfIndoorWorkout.insert(workout);
      __insertionAdapterOfIndoorSample.insert(samples);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWorkout(final IndoorWorkout workout) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfIndoorWorkout.insert(workout);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertSample(final IndoorSample sample) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfIndoorSample.insert(sample);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteWorkoutAndSamples(final IndoorWorkout workout, final IndoorSample[] toArray) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfIndoorWorkout.handle(workout);
      __deletionAdapterOfIndoorSample.handleMultiple(toArray);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteWorkout(final IndoorWorkout workout) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfIndoorWorkout.handle(workout);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteSample(final IndoorSample sample) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfIndoorSample.handle(sample);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateWorkout(final IndoorWorkout workout) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfIndoorWorkout.handle(workout);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateSamples(final IndoorSample[] samples) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfIndoorSample.handleMultiple(samples);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateSample(final IndoorSample sample) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfIndoorSample.handle(sample);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public IndoorWorkout findById(final long id) {
    final String _sql = "SELECT * FROM indoor_workout WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfRepetitions = CursorUtil.getColumnIndexOrThrow(_cursor, "repetitions");
      final int _cursorIndexOfAvgFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "avgFrequency");
      final int _cursorIndexOfMaxFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "maxFrequency");
      final int _cursorIndexOfMaxIntensity = CursorUtil.getColumnIndexOrThrow(_cursor, "maxIntensity");
      final int _cursorIndexOfAvgIntensity = CursorUtil.getColumnIndexOrThrow(_cursor, "avgIntensity");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfStart = CursorUtil.getColumnIndexOrThrow(_cursor, "start");
      final int _cursorIndexOfEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "end");
      final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
      final int _cursorIndexOfPauseDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "pauseDuration");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfWorkoutTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "workoutType");
      final int _cursorIndexOfAvgHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "avg_heart_rate");
      final int _cursorIndexOfMaxHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "max_heart_rate");
      final int _cursorIndexOfCalorie = CursorUtil.getColumnIndexOrThrow(_cursor, "calorie");
      final int _cursorIndexOfEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "edited");
      final int _cursorIndexOfIntervalSetUsedId = CursorUtil.getColumnIndexOrThrow(_cursor, "interval_set_used_id");
      final IndoorWorkout _result;
      if(_cursor.moveToFirst()) {
        _result = new IndoorWorkout();
        _result.repetitions = _cursor.getInt(_cursorIndexOfRepetitions);
        _result.avgFrequency = _cursor.getDouble(_cursorIndexOfAvgFrequency);
        _result.maxFrequency = _cursor.getDouble(_cursorIndexOfMaxFrequency);
        _result.maxIntensity = _cursor.getDouble(_cursorIndexOfMaxIntensity);
        _result.avgIntensity = _cursor.getDouble(_cursorIndexOfAvgIntensity);
        _result.id = _cursor.getLong(_cursorIndexOfId);
        _result.start = _cursor.getLong(_cursorIndexOfStart);
        _result.end = _cursor.getLong(_cursorIndexOfEnd);
        _result.duration = _cursor.getLong(_cursorIndexOfDuration);
        _result.pauseDuration = _cursor.getLong(_cursorIndexOfPauseDuration);
        if (_cursor.isNull(_cursorIndexOfComment)) {
          _result.comment = null;
        } else {
          _result.comment = _cursor.getString(_cursorIndexOfComment);
        }
        if (_cursor.isNull(_cursorIndexOfWorkoutTypeId)) {
          _result.workoutTypeId = null;
        } else {
          _result.workoutTypeId = _cursor.getString(_cursorIndexOfWorkoutTypeId);
        }
        _result.avgHeartRate = _cursor.getInt(_cursorIndexOfAvgHeartRate);
        _result.maxHeartRate = _cursor.getInt(_cursorIndexOfMaxHeartRate);
        _result.calorie = _cursor.getInt(_cursorIndexOfCalorie);
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfEdited);
        _result.edited = _tmp != 0;
        _result.intervalSetUsedId = _cursor.getLong(_cursorIndexOfIntervalSetUsedId);
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
  public IndoorSample findSampleById(final long id) {
    final String _sql = "SELECT * FROM indoor_sample WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfWorkoutId = CursorUtil.getColumnIndexOrThrow(_cursor, "workout_id");
      final int _cursorIndexOfRepetitions = CursorUtil.getColumnIndexOrThrow(_cursor, "repetitions");
      final int _cursorIndexOfAbsoluteEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "absoluteEndTime");
      final int _cursorIndexOfIntensity = CursorUtil.getColumnIndexOrThrow(_cursor, "intensity");
      final int _cursorIndexOfFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "frequency");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfAbsoluteTime = CursorUtil.getColumnIndexOrThrow(_cursor, "absoluteTime");
      final int _cursorIndexOfRelativeTime = CursorUtil.getColumnIndexOrThrow(_cursor, "relativeTime");
      final int _cursorIndexOfHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "heart_rate");
      final int _cursorIndexOfIntervalTriggered = CursorUtil.getColumnIndexOrThrow(_cursor, "interval_triggered");
      final IndoorSample _result;
      if(_cursor.moveToFirst()) {
        _result = new IndoorSample();
        _result.workoutId = _cursor.getLong(_cursorIndexOfWorkoutId);
        _result.repetitions = _cursor.getInt(_cursorIndexOfRepetitions);
        _result.absoluteEndTime = _cursor.getLong(_cursorIndexOfAbsoluteEndTime);
        _result.intensity = _cursor.getDouble(_cursorIndexOfIntensity);
        _result.frequency = _cursor.getDouble(_cursorIndexOfFrequency);
        _result.id = _cursor.getLong(_cursorIndexOfId);
        _result.absoluteTime = _cursor.getLong(_cursorIndexOfAbsoluteTime);
        _result.relativeTime = _cursor.getLong(_cursorIndexOfRelativeTime);
        _result.heartRate = _cursor.getInt(_cursorIndexOfHeartRate);
        _result.intervalTriggered = _cursor.getLong(_cursorIndexOfIntervalTriggered);
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
  public IndoorSample[] getAllSamplesOfWorkout(final long workout_id) {
    final String _sql = "SELECT * FROM indoor_sample WHERE workout_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, workout_id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfWorkoutId = CursorUtil.getColumnIndexOrThrow(_cursor, "workout_id");
      final int _cursorIndexOfRepetitions = CursorUtil.getColumnIndexOrThrow(_cursor, "repetitions");
      final int _cursorIndexOfAbsoluteEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "absoluteEndTime");
      final int _cursorIndexOfIntensity = CursorUtil.getColumnIndexOrThrow(_cursor, "intensity");
      final int _cursorIndexOfFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "frequency");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfAbsoluteTime = CursorUtil.getColumnIndexOrThrow(_cursor, "absoluteTime");
      final int _cursorIndexOfRelativeTime = CursorUtil.getColumnIndexOrThrow(_cursor, "relativeTime");
      final int _cursorIndexOfHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "heart_rate");
      final int _cursorIndexOfIntervalTriggered = CursorUtil.getColumnIndexOrThrow(_cursor, "interval_triggered");
      final IndoorSample[] _result = new IndoorSample[_cursor.getCount()];
      int _index = 0;
      while(_cursor.moveToNext()) {
        final IndoorSample _item;
        _item = new IndoorSample();
        _item.workoutId = _cursor.getLong(_cursorIndexOfWorkoutId);
        _item.repetitions = _cursor.getInt(_cursorIndexOfRepetitions);
        _item.absoluteEndTime = _cursor.getLong(_cursorIndexOfAbsoluteEndTime);
        _item.intensity = _cursor.getDouble(_cursorIndexOfIntensity);
        _item.frequency = _cursor.getDouble(_cursorIndexOfFrequency);
        _item.id = _cursor.getLong(_cursorIndexOfId);
        _item.absoluteTime = _cursor.getLong(_cursorIndexOfAbsoluteTime);
        _item.relativeTime = _cursor.getLong(_cursorIndexOfRelativeTime);
        _item.heartRate = _cursor.getInt(_cursorIndexOfHeartRate);
        _item.intervalTriggered = _cursor.getLong(_cursorIndexOfIntervalTriggered);
        _result[_index] = _item;
        _index ++;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public IndoorWorkout[] getWorkouts() {
    final String _sql = "SELECT * FROM indoor_workout ORDER BY start DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfRepetitions = CursorUtil.getColumnIndexOrThrow(_cursor, "repetitions");
      final int _cursorIndexOfAvgFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "avgFrequency");
      final int _cursorIndexOfMaxFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "maxFrequency");
      final int _cursorIndexOfMaxIntensity = CursorUtil.getColumnIndexOrThrow(_cursor, "maxIntensity");
      final int _cursorIndexOfAvgIntensity = CursorUtil.getColumnIndexOrThrow(_cursor, "avgIntensity");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfStart = CursorUtil.getColumnIndexOrThrow(_cursor, "start");
      final int _cursorIndexOfEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "end");
      final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
      final int _cursorIndexOfPauseDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "pauseDuration");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfWorkoutTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "workoutType");
      final int _cursorIndexOfAvgHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "avg_heart_rate");
      final int _cursorIndexOfMaxHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "max_heart_rate");
      final int _cursorIndexOfCalorie = CursorUtil.getColumnIndexOrThrow(_cursor, "calorie");
      final int _cursorIndexOfEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "edited");
      final int _cursorIndexOfIntervalSetUsedId = CursorUtil.getColumnIndexOrThrow(_cursor, "interval_set_used_id");
      final IndoorWorkout[] _result = new IndoorWorkout[_cursor.getCount()];
      int _index = 0;
      while(_cursor.moveToNext()) {
        final IndoorWorkout _item;
        _item = new IndoorWorkout();
        _item.repetitions = _cursor.getInt(_cursorIndexOfRepetitions);
        _item.avgFrequency = _cursor.getDouble(_cursorIndexOfAvgFrequency);
        _item.maxFrequency = _cursor.getDouble(_cursorIndexOfMaxFrequency);
        _item.maxIntensity = _cursor.getDouble(_cursorIndexOfMaxIntensity);
        _item.avgIntensity = _cursor.getDouble(_cursorIndexOfAvgIntensity);
        _item.id = _cursor.getLong(_cursorIndexOfId);
        _item.start = _cursor.getLong(_cursorIndexOfStart);
        _item.end = _cursor.getLong(_cursorIndexOfEnd);
        _item.duration = _cursor.getLong(_cursorIndexOfDuration);
        _item.pauseDuration = _cursor.getLong(_cursorIndexOfPauseDuration);
        if (_cursor.isNull(_cursorIndexOfComment)) {
          _item.comment = null;
        } else {
          _item.comment = _cursor.getString(_cursorIndexOfComment);
        }
        if (_cursor.isNull(_cursorIndexOfWorkoutTypeId)) {
          _item.workoutTypeId = null;
        } else {
          _item.workoutTypeId = _cursor.getString(_cursorIndexOfWorkoutTypeId);
        }
        _item.avgHeartRate = _cursor.getInt(_cursorIndexOfAvgHeartRate);
        _item.maxHeartRate = _cursor.getInt(_cursorIndexOfMaxHeartRate);
        _item.calorie = _cursor.getInt(_cursorIndexOfCalorie);
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfEdited);
        _item.edited = _tmp != 0;
        _item.intervalSetUsedId = _cursor.getLong(_cursorIndexOfIntervalSetUsedId);
        _result[_index] = _item;
        _index ++;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public IndoorWorkout getLastWorkout() {
    final String _sql = "SELECT * FROM indoor_workout ORDER BY start DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfRepetitions = CursorUtil.getColumnIndexOrThrow(_cursor, "repetitions");
      final int _cursorIndexOfAvgFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "avgFrequency");
      final int _cursorIndexOfMaxFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "maxFrequency");
      final int _cursorIndexOfMaxIntensity = CursorUtil.getColumnIndexOrThrow(_cursor, "maxIntensity");
      final int _cursorIndexOfAvgIntensity = CursorUtil.getColumnIndexOrThrow(_cursor, "avgIntensity");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfStart = CursorUtil.getColumnIndexOrThrow(_cursor, "start");
      final int _cursorIndexOfEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "end");
      final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
      final int _cursorIndexOfPauseDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "pauseDuration");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfWorkoutTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "workoutType");
      final int _cursorIndexOfAvgHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "avg_heart_rate");
      final int _cursorIndexOfMaxHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "max_heart_rate");
      final int _cursorIndexOfCalorie = CursorUtil.getColumnIndexOrThrow(_cursor, "calorie");
      final int _cursorIndexOfEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "edited");
      final int _cursorIndexOfIntervalSetUsedId = CursorUtil.getColumnIndexOrThrow(_cursor, "interval_set_used_id");
      final IndoorWorkout _result;
      if(_cursor.moveToFirst()) {
        _result = new IndoorWorkout();
        _result.repetitions = _cursor.getInt(_cursorIndexOfRepetitions);
        _result.avgFrequency = _cursor.getDouble(_cursorIndexOfAvgFrequency);
        _result.maxFrequency = _cursor.getDouble(_cursorIndexOfMaxFrequency);
        _result.maxIntensity = _cursor.getDouble(_cursorIndexOfMaxIntensity);
        _result.avgIntensity = _cursor.getDouble(_cursorIndexOfAvgIntensity);
        _result.id = _cursor.getLong(_cursorIndexOfId);
        _result.start = _cursor.getLong(_cursorIndexOfStart);
        _result.end = _cursor.getLong(_cursorIndexOfEnd);
        _result.duration = _cursor.getLong(_cursorIndexOfDuration);
        _result.pauseDuration = _cursor.getLong(_cursorIndexOfPauseDuration);
        if (_cursor.isNull(_cursorIndexOfComment)) {
          _result.comment = null;
        } else {
          _result.comment = _cursor.getString(_cursorIndexOfComment);
        }
        if (_cursor.isNull(_cursorIndexOfWorkoutTypeId)) {
          _result.workoutTypeId = null;
        } else {
          _result.workoutTypeId = _cursor.getString(_cursorIndexOfWorkoutTypeId);
        }
        _result.avgHeartRate = _cursor.getInt(_cursorIndexOfAvgHeartRate);
        _result.maxHeartRate = _cursor.getInt(_cursorIndexOfMaxHeartRate);
        _result.calorie = _cursor.getInt(_cursorIndexOfCalorie);
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfEdited);
        _result.edited = _tmp != 0;
        _result.intervalSetUsedId = _cursor.getLong(_cursorIndexOfIntervalSetUsedId);
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
  public IndoorWorkout getLastWorkoutByType(final String type) {
    final String _sql = "SELECT * FROM indoor_workout WHERE workoutType = ? ORDER BY start DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, type);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfRepetitions = CursorUtil.getColumnIndexOrThrow(_cursor, "repetitions");
      final int _cursorIndexOfAvgFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "avgFrequency");
      final int _cursorIndexOfMaxFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "maxFrequency");
      final int _cursorIndexOfMaxIntensity = CursorUtil.getColumnIndexOrThrow(_cursor, "maxIntensity");
      final int _cursorIndexOfAvgIntensity = CursorUtil.getColumnIndexOrThrow(_cursor, "avgIntensity");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfStart = CursorUtil.getColumnIndexOrThrow(_cursor, "start");
      final int _cursorIndexOfEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "end");
      final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
      final int _cursorIndexOfPauseDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "pauseDuration");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfWorkoutTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "workoutType");
      final int _cursorIndexOfAvgHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "avg_heart_rate");
      final int _cursorIndexOfMaxHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "max_heart_rate");
      final int _cursorIndexOfCalorie = CursorUtil.getColumnIndexOrThrow(_cursor, "calorie");
      final int _cursorIndexOfEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "edited");
      final int _cursorIndexOfIntervalSetUsedId = CursorUtil.getColumnIndexOrThrow(_cursor, "interval_set_used_id");
      final IndoorWorkout _result;
      if(_cursor.moveToFirst()) {
        _result = new IndoorWorkout();
        _result.repetitions = _cursor.getInt(_cursorIndexOfRepetitions);
        _result.avgFrequency = _cursor.getDouble(_cursorIndexOfAvgFrequency);
        _result.maxFrequency = _cursor.getDouble(_cursorIndexOfMaxFrequency);
        _result.maxIntensity = _cursor.getDouble(_cursorIndexOfMaxIntensity);
        _result.avgIntensity = _cursor.getDouble(_cursorIndexOfAvgIntensity);
        _result.id = _cursor.getLong(_cursorIndexOfId);
        _result.start = _cursor.getLong(_cursorIndexOfStart);
        _result.end = _cursor.getLong(_cursorIndexOfEnd);
        _result.duration = _cursor.getLong(_cursorIndexOfDuration);
        _result.pauseDuration = _cursor.getLong(_cursorIndexOfPauseDuration);
        if (_cursor.isNull(_cursorIndexOfComment)) {
          _result.comment = null;
        } else {
          _result.comment = _cursor.getString(_cursorIndexOfComment);
        }
        if (_cursor.isNull(_cursorIndexOfWorkoutTypeId)) {
          _result.workoutTypeId = null;
        } else {
          _result.workoutTypeId = _cursor.getString(_cursorIndexOfWorkoutTypeId);
        }
        _result.avgHeartRate = _cursor.getInt(_cursorIndexOfAvgHeartRate);
        _result.maxHeartRate = _cursor.getInt(_cursorIndexOfMaxHeartRate);
        _result.calorie = _cursor.getInt(_cursorIndexOfCalorie);
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfEdited);
        _result.edited = _tmp != 0;
        _result.intervalSetUsedId = _cursor.getLong(_cursorIndexOfIntervalSetUsedId);
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
  public IndoorWorkout[] getAllWorkoutsHistorically() {
    final String _sql = "SELECT * FROM indoor_workout ORDER BY start ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfRepetitions = CursorUtil.getColumnIndexOrThrow(_cursor, "repetitions");
      final int _cursorIndexOfAvgFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "avgFrequency");
      final int _cursorIndexOfMaxFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "maxFrequency");
      final int _cursorIndexOfMaxIntensity = CursorUtil.getColumnIndexOrThrow(_cursor, "maxIntensity");
      final int _cursorIndexOfAvgIntensity = CursorUtil.getColumnIndexOrThrow(_cursor, "avgIntensity");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfStart = CursorUtil.getColumnIndexOrThrow(_cursor, "start");
      final int _cursorIndexOfEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "end");
      final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
      final int _cursorIndexOfPauseDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "pauseDuration");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfWorkoutTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "workoutType");
      final int _cursorIndexOfAvgHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "avg_heart_rate");
      final int _cursorIndexOfMaxHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "max_heart_rate");
      final int _cursorIndexOfCalorie = CursorUtil.getColumnIndexOrThrow(_cursor, "calorie");
      final int _cursorIndexOfEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "edited");
      final int _cursorIndexOfIntervalSetUsedId = CursorUtil.getColumnIndexOrThrow(_cursor, "interval_set_used_id");
      final IndoorWorkout[] _result = new IndoorWorkout[_cursor.getCount()];
      int _index = 0;
      while(_cursor.moveToNext()) {
        final IndoorWorkout _item;
        _item = new IndoorWorkout();
        _item.repetitions = _cursor.getInt(_cursorIndexOfRepetitions);
        _item.avgFrequency = _cursor.getDouble(_cursorIndexOfAvgFrequency);
        _item.maxFrequency = _cursor.getDouble(_cursorIndexOfMaxFrequency);
        _item.maxIntensity = _cursor.getDouble(_cursorIndexOfMaxIntensity);
        _item.avgIntensity = _cursor.getDouble(_cursorIndexOfAvgIntensity);
        _item.id = _cursor.getLong(_cursorIndexOfId);
        _item.start = _cursor.getLong(_cursorIndexOfStart);
        _item.end = _cursor.getLong(_cursorIndexOfEnd);
        _item.duration = _cursor.getLong(_cursorIndexOfDuration);
        _item.pauseDuration = _cursor.getLong(_cursorIndexOfPauseDuration);
        if (_cursor.isNull(_cursorIndexOfComment)) {
          _item.comment = null;
        } else {
          _item.comment = _cursor.getString(_cursorIndexOfComment);
        }
        if (_cursor.isNull(_cursorIndexOfWorkoutTypeId)) {
          _item.workoutTypeId = null;
        } else {
          _item.workoutTypeId = _cursor.getString(_cursorIndexOfWorkoutTypeId);
        }
        _item.avgHeartRate = _cursor.getInt(_cursorIndexOfAvgHeartRate);
        _item.maxHeartRate = _cursor.getInt(_cursorIndexOfMaxHeartRate);
        _item.calorie = _cursor.getInt(_cursorIndexOfCalorie);
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfEdited);
        _item.edited = _tmp != 0;
        _item.intervalSetUsedId = _cursor.getLong(_cursorIndexOfIntervalSetUsedId);
        _result[_index] = _item;
        _index ++;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public IndoorWorkout[] getWorkoutsHistorically(final String workout_type) {
    final String _sql = "SELECT * FROM indoor_workout WHERE workoutType = ? ORDER BY start ASC ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (workout_type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, workout_type);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfRepetitions = CursorUtil.getColumnIndexOrThrow(_cursor, "repetitions");
      final int _cursorIndexOfAvgFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "avgFrequency");
      final int _cursorIndexOfMaxFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "maxFrequency");
      final int _cursorIndexOfMaxIntensity = CursorUtil.getColumnIndexOrThrow(_cursor, "maxIntensity");
      final int _cursorIndexOfAvgIntensity = CursorUtil.getColumnIndexOrThrow(_cursor, "avgIntensity");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfStart = CursorUtil.getColumnIndexOrThrow(_cursor, "start");
      final int _cursorIndexOfEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "end");
      final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
      final int _cursorIndexOfPauseDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "pauseDuration");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfWorkoutTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "workoutType");
      final int _cursorIndexOfAvgHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "avg_heart_rate");
      final int _cursorIndexOfMaxHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "max_heart_rate");
      final int _cursorIndexOfCalorie = CursorUtil.getColumnIndexOrThrow(_cursor, "calorie");
      final int _cursorIndexOfEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "edited");
      final int _cursorIndexOfIntervalSetUsedId = CursorUtil.getColumnIndexOrThrow(_cursor, "interval_set_used_id");
      final IndoorWorkout[] _result = new IndoorWorkout[_cursor.getCount()];
      int _index = 0;
      while(_cursor.moveToNext()) {
        final IndoorWorkout _item;
        _item = new IndoorWorkout();
        _item.repetitions = _cursor.getInt(_cursorIndexOfRepetitions);
        _item.avgFrequency = _cursor.getDouble(_cursorIndexOfAvgFrequency);
        _item.maxFrequency = _cursor.getDouble(_cursorIndexOfMaxFrequency);
        _item.maxIntensity = _cursor.getDouble(_cursorIndexOfMaxIntensity);
        _item.avgIntensity = _cursor.getDouble(_cursorIndexOfAvgIntensity);
        _item.id = _cursor.getLong(_cursorIndexOfId);
        _item.start = _cursor.getLong(_cursorIndexOfStart);
        _item.end = _cursor.getLong(_cursorIndexOfEnd);
        _item.duration = _cursor.getLong(_cursorIndexOfDuration);
        _item.pauseDuration = _cursor.getLong(_cursorIndexOfPauseDuration);
        if (_cursor.isNull(_cursorIndexOfComment)) {
          _item.comment = null;
        } else {
          _item.comment = _cursor.getString(_cursorIndexOfComment);
        }
        if (_cursor.isNull(_cursorIndexOfWorkoutTypeId)) {
          _item.workoutTypeId = null;
        } else {
          _item.workoutTypeId = _cursor.getString(_cursorIndexOfWorkoutTypeId);
        }
        _item.avgHeartRate = _cursor.getInt(_cursorIndexOfAvgHeartRate);
        _item.maxHeartRate = _cursor.getInt(_cursorIndexOfMaxHeartRate);
        _item.calorie = _cursor.getInt(_cursorIndexOfCalorie);
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfEdited);
        _item.edited = _tmp != 0;
        _item.intervalSetUsedId = _cursor.getLong(_cursorIndexOfIntervalSetUsedId);
        _result[_index] = _item;
        _index ++;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public IndoorWorkout getWorkoutByStart(final long start) {
    final String _sql = "SELECT * FROM indoor_workout WHERE start = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, start);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfRepetitions = CursorUtil.getColumnIndexOrThrow(_cursor, "repetitions");
      final int _cursorIndexOfAvgFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "avgFrequency");
      final int _cursorIndexOfMaxFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "maxFrequency");
      final int _cursorIndexOfMaxIntensity = CursorUtil.getColumnIndexOrThrow(_cursor, "maxIntensity");
      final int _cursorIndexOfAvgIntensity = CursorUtil.getColumnIndexOrThrow(_cursor, "avgIntensity");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfStart = CursorUtil.getColumnIndexOrThrow(_cursor, "start");
      final int _cursorIndexOfEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "end");
      final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
      final int _cursorIndexOfPauseDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "pauseDuration");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfWorkoutTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "workoutType");
      final int _cursorIndexOfAvgHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "avg_heart_rate");
      final int _cursorIndexOfMaxHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "max_heart_rate");
      final int _cursorIndexOfCalorie = CursorUtil.getColumnIndexOrThrow(_cursor, "calorie");
      final int _cursorIndexOfEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "edited");
      final int _cursorIndexOfIntervalSetUsedId = CursorUtil.getColumnIndexOrThrow(_cursor, "interval_set_used_id");
      final IndoorWorkout _result;
      if(_cursor.moveToFirst()) {
        _result = new IndoorWorkout();
        _result.repetitions = _cursor.getInt(_cursorIndexOfRepetitions);
        _result.avgFrequency = _cursor.getDouble(_cursorIndexOfAvgFrequency);
        _result.maxFrequency = _cursor.getDouble(_cursorIndexOfMaxFrequency);
        _result.maxIntensity = _cursor.getDouble(_cursorIndexOfMaxIntensity);
        _result.avgIntensity = _cursor.getDouble(_cursorIndexOfAvgIntensity);
        _result.id = _cursor.getLong(_cursorIndexOfId);
        _result.start = _cursor.getLong(_cursorIndexOfStart);
        _result.end = _cursor.getLong(_cursorIndexOfEnd);
        _result.duration = _cursor.getLong(_cursorIndexOfDuration);
        _result.pauseDuration = _cursor.getLong(_cursorIndexOfPauseDuration);
        if (_cursor.isNull(_cursorIndexOfComment)) {
          _result.comment = null;
        } else {
          _result.comment = _cursor.getString(_cursorIndexOfComment);
        }
        if (_cursor.isNull(_cursorIndexOfWorkoutTypeId)) {
          _result.workoutTypeId = null;
        } else {
          _result.workoutTypeId = _cursor.getString(_cursorIndexOfWorkoutTypeId);
        }
        _result.avgHeartRate = _cursor.getInt(_cursorIndexOfAvgHeartRate);
        _result.maxHeartRate = _cursor.getInt(_cursorIndexOfMaxHeartRate);
        _result.calorie = _cursor.getInt(_cursorIndexOfCalorie);
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfEdited);
        _result.edited = _tmp != 0;
        _result.intervalSetUsedId = _cursor.getLong(_cursorIndexOfIntervalSetUsedId);
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
  public IndoorWorkout getWorkoutById(final long id) {
    final String _sql = "SELECT * FROM indoor_workout WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfRepetitions = CursorUtil.getColumnIndexOrThrow(_cursor, "repetitions");
      final int _cursorIndexOfAvgFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "avgFrequency");
      final int _cursorIndexOfMaxFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "maxFrequency");
      final int _cursorIndexOfMaxIntensity = CursorUtil.getColumnIndexOrThrow(_cursor, "maxIntensity");
      final int _cursorIndexOfAvgIntensity = CursorUtil.getColumnIndexOrThrow(_cursor, "avgIntensity");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfStart = CursorUtil.getColumnIndexOrThrow(_cursor, "start");
      final int _cursorIndexOfEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "end");
      final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
      final int _cursorIndexOfPauseDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "pauseDuration");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfWorkoutTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "workoutType");
      final int _cursorIndexOfAvgHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "avg_heart_rate");
      final int _cursorIndexOfMaxHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "max_heart_rate");
      final int _cursorIndexOfCalorie = CursorUtil.getColumnIndexOrThrow(_cursor, "calorie");
      final int _cursorIndexOfEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "edited");
      final int _cursorIndexOfIntervalSetUsedId = CursorUtil.getColumnIndexOrThrow(_cursor, "interval_set_used_id");
      final IndoorWorkout _result;
      if(_cursor.moveToFirst()) {
        _result = new IndoorWorkout();
        _result.repetitions = _cursor.getInt(_cursorIndexOfRepetitions);
        _result.avgFrequency = _cursor.getDouble(_cursorIndexOfAvgFrequency);
        _result.maxFrequency = _cursor.getDouble(_cursorIndexOfMaxFrequency);
        _result.maxIntensity = _cursor.getDouble(_cursorIndexOfMaxIntensity);
        _result.avgIntensity = _cursor.getDouble(_cursorIndexOfAvgIntensity);
        _result.id = _cursor.getLong(_cursorIndexOfId);
        _result.start = _cursor.getLong(_cursorIndexOfStart);
        _result.end = _cursor.getLong(_cursorIndexOfEnd);
        _result.duration = _cursor.getLong(_cursorIndexOfDuration);
        _result.pauseDuration = _cursor.getLong(_cursorIndexOfPauseDuration);
        if (_cursor.isNull(_cursorIndexOfComment)) {
          _result.comment = null;
        } else {
          _result.comment = _cursor.getString(_cursorIndexOfComment);
        }
        if (_cursor.isNull(_cursorIndexOfWorkoutTypeId)) {
          _result.workoutTypeId = null;
        } else {
          _result.workoutTypeId = _cursor.getString(_cursorIndexOfWorkoutTypeId);
        }
        _result.avgHeartRate = _cursor.getInt(_cursorIndexOfAvgHeartRate);
        _result.maxHeartRate = _cursor.getInt(_cursorIndexOfMaxHeartRate);
        _result.calorie = _cursor.getInt(_cursorIndexOfCalorie);
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfEdited);
        _result.edited = _tmp != 0;
        _result.intervalSetUsedId = _cursor.getLong(_cursorIndexOfIntervalSetUsedId);
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
  public IndoorSample[] getSamples() {
    final String _sql = "SELECT * FROM indoor_sample";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfWorkoutId = CursorUtil.getColumnIndexOrThrow(_cursor, "workout_id");
      final int _cursorIndexOfRepetitions = CursorUtil.getColumnIndexOrThrow(_cursor, "repetitions");
      final int _cursorIndexOfAbsoluteEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "absoluteEndTime");
      final int _cursorIndexOfIntensity = CursorUtil.getColumnIndexOrThrow(_cursor, "intensity");
      final int _cursorIndexOfFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "frequency");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfAbsoluteTime = CursorUtil.getColumnIndexOrThrow(_cursor, "absoluteTime");
      final int _cursorIndexOfRelativeTime = CursorUtil.getColumnIndexOrThrow(_cursor, "relativeTime");
      final int _cursorIndexOfHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "heart_rate");
      final int _cursorIndexOfIntervalTriggered = CursorUtil.getColumnIndexOrThrow(_cursor, "interval_triggered");
      final IndoorSample[] _result = new IndoorSample[_cursor.getCount()];
      int _index = 0;
      while(_cursor.moveToNext()) {
        final IndoorSample _item;
        _item = new IndoorSample();
        _item.workoutId = _cursor.getLong(_cursorIndexOfWorkoutId);
        _item.repetitions = _cursor.getInt(_cursorIndexOfRepetitions);
        _item.absoluteEndTime = _cursor.getLong(_cursorIndexOfAbsoluteEndTime);
        _item.intensity = _cursor.getDouble(_cursorIndexOfIntensity);
        _item.frequency = _cursor.getDouble(_cursorIndexOfFrequency);
        _item.id = _cursor.getLong(_cursorIndexOfId);
        _item.absoluteTime = _cursor.getLong(_cursorIndexOfAbsoluteTime);
        _item.relativeTime = _cursor.getLong(_cursorIndexOfRelativeTime);
        _item.heartRate = _cursor.getInt(_cursorIndexOfHeartRate);
        _item.intervalTriggered = _cursor.getLong(_cursorIndexOfIntervalTriggered);
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
