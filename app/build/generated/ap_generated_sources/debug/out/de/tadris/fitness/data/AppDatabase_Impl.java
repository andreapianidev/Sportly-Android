package de.tadris.fitness.data;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile GpsWorkoutDao _gpsWorkoutDao;

  private volatile IndoorWorkoutDao _indoorWorkoutDao;

  private volatile WorkoutTypeDao _workoutTypeDao;

  private volatile IntervalDao _intervalDao;

  private volatile ExportTargetDao _exportTargetDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(16) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `workout` (`length` INTEGER NOT NULL, `avgSpeed` REAL NOT NULL, `topSpeed` REAL NOT NULL, `avgPace` REAL NOT NULL, `min_elevation_msl` REAL NOT NULL, `max_elevation_msl` REAL NOT NULL, `ascent` REAL NOT NULL, `descent` REAL NOT NULL, `id` INTEGER NOT NULL, `start` INTEGER NOT NULL, `end` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `pauseDuration` INTEGER NOT NULL, `comment` TEXT, `workoutType` TEXT, `avg_heart_rate` INTEGER NOT NULL, `max_heart_rate` INTEGER NOT NULL, `calorie` INTEGER NOT NULL, `edited` INTEGER NOT NULL, `interval_set_used_id` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `workout_sample` (`workout_id` INTEGER NOT NULL, `lat` REAL NOT NULL, `lon` REAL NOT NULL, `elevation` REAL NOT NULL, `elevation_msl` REAL NOT NULL, `speed` REAL NOT NULL, `pressure` REAL NOT NULL, `id` INTEGER NOT NULL, `absoluteTime` INTEGER NOT NULL, `relativeTime` INTEGER NOT NULL, `heart_rate` INTEGER NOT NULL, `interval_triggered` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`workout_id`) REFERENCES `workout`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_workout_sample_workout_id` ON `workout_sample` (`workout_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `indoor_workout` (`repetitions` INTEGER NOT NULL, `avgFrequency` REAL NOT NULL, `maxFrequency` REAL NOT NULL, `maxIntensity` REAL NOT NULL, `avgIntensity` REAL NOT NULL, `id` INTEGER NOT NULL, `start` INTEGER NOT NULL, `end` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `pauseDuration` INTEGER NOT NULL, `comment` TEXT, `workoutType` TEXT, `avg_heart_rate` INTEGER NOT NULL, `max_heart_rate` INTEGER NOT NULL, `calorie` INTEGER NOT NULL, `edited` INTEGER NOT NULL, `interval_set_used_id` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `indoor_sample` (`workout_id` INTEGER NOT NULL, `repetitions` INTEGER NOT NULL, `absoluteEndTime` INTEGER NOT NULL, `intensity` REAL NOT NULL, `frequency` REAL NOT NULL, `id` INTEGER NOT NULL, `absoluteTime` INTEGER NOT NULL, `relativeTime` INTEGER NOT NULL, `heart_rate` INTEGER NOT NULL, `interval_triggered` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`workout_id`) REFERENCES `indoor_workout`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_indoor_sample_workout_id` ON `indoor_sample` (`workout_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `interval` (`id` INTEGER NOT NULL, `set_id` INTEGER NOT NULL, `name` TEXT, `delay_millis` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`set_id`) REFERENCES `interval_set`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_interval_set_id` ON `interval` (`set_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `interval_set` (`id` INTEGER NOT NULL, `name` TEXT, `state` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `workout_type` (`id` TEXT NOT NULL, `title` TEXT, `min_distance` INTEGER NOT NULL, `color` INTEGER NOT NULL, `icon` TEXT, `met` INTEGER NOT NULL, `type` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `export_target_config` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `source` TEXT, `type` TEXT, `data` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'bf539056e8c4210278c0e5e1758ae638')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `workout`");
        _db.execSQL("DROP TABLE IF EXISTS `workout_sample`");
        _db.execSQL("DROP TABLE IF EXISTS `indoor_workout`");
        _db.execSQL("DROP TABLE IF EXISTS `indoor_sample`");
        _db.execSQL("DROP TABLE IF EXISTS `interval`");
        _db.execSQL("DROP TABLE IF EXISTS `interval_set`");
        _db.execSQL("DROP TABLE IF EXISTS `workout_type`");
        _db.execSQL("DROP TABLE IF EXISTS `export_target_config`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsWorkout = new HashMap<String, TableInfo.Column>(20);
        _columnsWorkout.put("length", new TableInfo.Column("length", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkout.put("avgSpeed", new TableInfo.Column("avgSpeed", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkout.put("topSpeed", new TableInfo.Column("topSpeed", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkout.put("avgPace", new TableInfo.Column("avgPace", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkout.put("min_elevation_msl", new TableInfo.Column("min_elevation_msl", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkout.put("max_elevation_msl", new TableInfo.Column("max_elevation_msl", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkout.put("ascent", new TableInfo.Column("ascent", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkout.put("descent", new TableInfo.Column("descent", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkout.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkout.put("start", new TableInfo.Column("start", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkout.put("end", new TableInfo.Column("end", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkout.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkout.put("pauseDuration", new TableInfo.Column("pauseDuration", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkout.put("comment", new TableInfo.Column("comment", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkout.put("workoutType", new TableInfo.Column("workoutType", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkout.put("avg_heart_rate", new TableInfo.Column("avg_heart_rate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkout.put("max_heart_rate", new TableInfo.Column("max_heart_rate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkout.put("calorie", new TableInfo.Column("calorie", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkout.put("edited", new TableInfo.Column("edited", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkout.put("interval_set_used_id", new TableInfo.Column("interval_set_used_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWorkout = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWorkout = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWorkout = new TableInfo("workout", _columnsWorkout, _foreignKeysWorkout, _indicesWorkout);
        final TableInfo _existingWorkout = TableInfo.read(_db, "workout");
        if (! _infoWorkout.equals(_existingWorkout)) {
          return new RoomOpenHelper.ValidationResult(false, "workout(de.tadris.fitness.data.GpsWorkout).\n"
                  + " Expected:\n" + _infoWorkout + "\n"
                  + " Found:\n" + _existingWorkout);
        }
        final HashMap<String, TableInfo.Column> _columnsWorkoutSample = new HashMap<String, TableInfo.Column>(12);
        _columnsWorkoutSample.put("workout_id", new TableInfo.Column("workout_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutSample.put("lat", new TableInfo.Column("lat", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutSample.put("lon", new TableInfo.Column("lon", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutSample.put("elevation", new TableInfo.Column("elevation", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutSample.put("elevation_msl", new TableInfo.Column("elevation_msl", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutSample.put("speed", new TableInfo.Column("speed", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutSample.put("pressure", new TableInfo.Column("pressure", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutSample.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutSample.put("absoluteTime", new TableInfo.Column("absoluteTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutSample.put("relativeTime", new TableInfo.Column("relativeTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutSample.put("heart_rate", new TableInfo.Column("heart_rate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutSample.put("interval_triggered", new TableInfo.Column("interval_triggered", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWorkoutSample = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysWorkoutSample.add(new TableInfo.ForeignKey("workout", "CASCADE", "NO ACTION",Arrays.asList("workout_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesWorkoutSample = new HashSet<TableInfo.Index>(1);
        _indicesWorkoutSample.add(new TableInfo.Index("index_workout_sample_workout_id", false, Arrays.asList("workout_id"), Arrays.asList("ASC")));
        final TableInfo _infoWorkoutSample = new TableInfo("workout_sample", _columnsWorkoutSample, _foreignKeysWorkoutSample, _indicesWorkoutSample);
        final TableInfo _existingWorkoutSample = TableInfo.read(_db, "workout_sample");
        if (! _infoWorkoutSample.equals(_existingWorkoutSample)) {
          return new RoomOpenHelper.ValidationResult(false, "workout_sample(de.tadris.fitness.data.GpsSample).\n"
                  + " Expected:\n" + _infoWorkoutSample + "\n"
                  + " Found:\n" + _existingWorkoutSample);
        }
        final HashMap<String, TableInfo.Column> _columnsIndoorWorkout = new HashMap<String, TableInfo.Column>(17);
        _columnsIndoorWorkout.put("repetitions", new TableInfo.Column("repetitions", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIndoorWorkout.put("avgFrequency", new TableInfo.Column("avgFrequency", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIndoorWorkout.put("maxFrequency", new TableInfo.Column("maxFrequency", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIndoorWorkout.put("maxIntensity", new TableInfo.Column("maxIntensity", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIndoorWorkout.put("avgIntensity", new TableInfo.Column("avgIntensity", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIndoorWorkout.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIndoorWorkout.put("start", new TableInfo.Column("start", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIndoorWorkout.put("end", new TableInfo.Column("end", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIndoorWorkout.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIndoorWorkout.put("pauseDuration", new TableInfo.Column("pauseDuration", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIndoorWorkout.put("comment", new TableInfo.Column("comment", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIndoorWorkout.put("workoutType", new TableInfo.Column("workoutType", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIndoorWorkout.put("avg_heart_rate", new TableInfo.Column("avg_heart_rate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIndoorWorkout.put("max_heart_rate", new TableInfo.Column("max_heart_rate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIndoorWorkout.put("calorie", new TableInfo.Column("calorie", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIndoorWorkout.put("edited", new TableInfo.Column("edited", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIndoorWorkout.put("interval_set_used_id", new TableInfo.Column("interval_set_used_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysIndoorWorkout = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesIndoorWorkout = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoIndoorWorkout = new TableInfo("indoor_workout", _columnsIndoorWorkout, _foreignKeysIndoorWorkout, _indicesIndoorWorkout);
        final TableInfo _existingIndoorWorkout = TableInfo.read(_db, "indoor_workout");
        if (! _infoIndoorWorkout.equals(_existingIndoorWorkout)) {
          return new RoomOpenHelper.ValidationResult(false, "indoor_workout(de.tadris.fitness.data.IndoorWorkout).\n"
                  + " Expected:\n" + _infoIndoorWorkout + "\n"
                  + " Found:\n" + _existingIndoorWorkout);
        }
        final HashMap<String, TableInfo.Column> _columnsIndoorSample = new HashMap<String, TableInfo.Column>(10);
        _columnsIndoorSample.put("workout_id", new TableInfo.Column("workout_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIndoorSample.put("repetitions", new TableInfo.Column("repetitions", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIndoorSample.put("absoluteEndTime", new TableInfo.Column("absoluteEndTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIndoorSample.put("intensity", new TableInfo.Column("intensity", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIndoorSample.put("frequency", new TableInfo.Column("frequency", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIndoorSample.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIndoorSample.put("absoluteTime", new TableInfo.Column("absoluteTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIndoorSample.put("relativeTime", new TableInfo.Column("relativeTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIndoorSample.put("heart_rate", new TableInfo.Column("heart_rate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIndoorSample.put("interval_triggered", new TableInfo.Column("interval_triggered", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysIndoorSample = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysIndoorSample.add(new TableInfo.ForeignKey("indoor_workout", "CASCADE", "NO ACTION",Arrays.asList("workout_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesIndoorSample = new HashSet<TableInfo.Index>(1);
        _indicesIndoorSample.add(new TableInfo.Index("index_indoor_sample_workout_id", false, Arrays.asList("workout_id"), Arrays.asList("ASC")));
        final TableInfo _infoIndoorSample = new TableInfo("indoor_sample", _columnsIndoorSample, _foreignKeysIndoorSample, _indicesIndoorSample);
        final TableInfo _existingIndoorSample = TableInfo.read(_db, "indoor_sample");
        if (! _infoIndoorSample.equals(_existingIndoorSample)) {
          return new RoomOpenHelper.ValidationResult(false, "indoor_sample(de.tadris.fitness.data.IndoorSample).\n"
                  + " Expected:\n" + _infoIndoorSample + "\n"
                  + " Found:\n" + _existingIndoorSample);
        }
        final HashMap<String, TableInfo.Column> _columnsInterval = new HashMap<String, TableInfo.Column>(4);
        _columnsInterval.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInterval.put("set_id", new TableInfo.Column("set_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInterval.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInterval.put("delay_millis", new TableInfo.Column("delay_millis", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysInterval = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysInterval.add(new TableInfo.ForeignKey("interval_set", "CASCADE", "NO ACTION",Arrays.asList("set_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesInterval = new HashSet<TableInfo.Index>(1);
        _indicesInterval.add(new TableInfo.Index("index_interval_set_id", false, Arrays.asList("set_id"), Arrays.asList("ASC")));
        final TableInfo _infoInterval = new TableInfo("interval", _columnsInterval, _foreignKeysInterval, _indicesInterval);
        final TableInfo _existingInterval = TableInfo.read(_db, "interval");
        if (! _infoInterval.equals(_existingInterval)) {
          return new RoomOpenHelper.ValidationResult(false, "interval(de.tadris.fitness.data.Interval).\n"
                  + " Expected:\n" + _infoInterval + "\n"
                  + " Found:\n" + _existingInterval);
        }
        final HashMap<String, TableInfo.Column> _columnsIntervalSet = new HashMap<String, TableInfo.Column>(3);
        _columnsIntervalSet.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIntervalSet.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIntervalSet.put("state", new TableInfo.Column("state", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysIntervalSet = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesIntervalSet = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoIntervalSet = new TableInfo("interval_set", _columnsIntervalSet, _foreignKeysIntervalSet, _indicesIntervalSet);
        final TableInfo _existingIntervalSet = TableInfo.read(_db, "interval_set");
        if (! _infoIntervalSet.equals(_existingIntervalSet)) {
          return new RoomOpenHelper.ValidationResult(false, "interval_set(de.tadris.fitness.data.IntervalSet).\n"
                  + " Expected:\n" + _infoIntervalSet + "\n"
                  + " Found:\n" + _existingIntervalSet);
        }
        final HashMap<String, TableInfo.Column> _columnsWorkoutType = new HashMap<String, TableInfo.Column>(7);
        _columnsWorkoutType.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutType.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutType.put("min_distance", new TableInfo.Column("min_distance", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutType.put("color", new TableInfo.Column("color", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutType.put("icon", new TableInfo.Column("icon", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutType.put("met", new TableInfo.Column("met", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutType.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWorkoutType = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWorkoutType = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWorkoutType = new TableInfo("workout_type", _columnsWorkoutType, _foreignKeysWorkoutType, _indicesWorkoutType);
        final TableInfo _existingWorkoutType = TableInfo.read(_db, "workout_type");
        if (! _infoWorkoutType.equals(_existingWorkoutType)) {
          return new RoomOpenHelper.ValidationResult(false, "workout_type(de.tadris.fitness.data.WorkoutType).\n"
                  + " Expected:\n" + _infoWorkoutType + "\n"
                  + " Found:\n" + _existingWorkoutType);
        }
        final HashMap<String, TableInfo.Column> _columnsExportTargetConfig = new HashMap<String, TableInfo.Column>(4);
        _columnsExportTargetConfig.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExportTargetConfig.put("source", new TableInfo.Column("source", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExportTargetConfig.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExportTargetConfig.put("data", new TableInfo.Column("data", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysExportTargetConfig = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesExportTargetConfig = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoExportTargetConfig = new TableInfo("export_target_config", _columnsExportTargetConfig, _foreignKeysExportTargetConfig, _indicesExportTargetConfig);
        final TableInfo _existingExportTargetConfig = TableInfo.read(_db, "export_target_config");
        if (! _infoExportTargetConfig.equals(_existingExportTargetConfig)) {
          return new RoomOpenHelper.ValidationResult(false, "export_target_config(de.tadris.fitness.data.ExportTargetConfiguration).\n"
                  + " Expected:\n" + _infoExportTargetConfig + "\n"
                  + " Found:\n" + _existingExportTargetConfig);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "bf539056e8c4210278c0e5e1758ae638", "9201c442d29bc3f339275841c479ea93");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "workout","workout_sample","indoor_workout","indoor_sample","interval","interval_set","workout_type","export_target_config");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `workout`");
      _db.execSQL("DELETE FROM `workout_sample`");
      _db.execSQL("DELETE FROM `indoor_workout`");
      _db.execSQL("DELETE FROM `indoor_sample`");
      _db.execSQL("DELETE FROM `interval`");
      _db.execSQL("DELETE FROM `interval_set`");
      _db.execSQL("DELETE FROM `workout_type`");
      _db.execSQL("DELETE FROM `export_target_config`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(GpsWorkoutDao.class, GpsWorkoutDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(IndoorWorkoutDao.class, IndoorWorkoutDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(WorkoutTypeDao.class, WorkoutTypeDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(IntervalDao.class, IntervalDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ExportTargetDao.class, ExportTargetDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public GpsWorkoutDao gpsWorkoutDao() {
    if (_gpsWorkoutDao != null) {
      return _gpsWorkoutDao;
    } else {
      synchronized(this) {
        if(_gpsWorkoutDao == null) {
          _gpsWorkoutDao = new GpsWorkoutDao_Impl(this);
        }
        return _gpsWorkoutDao;
      }
    }
  }

  @Override
  public IndoorWorkoutDao indoorWorkoutDao() {
    if (_indoorWorkoutDao != null) {
      return _indoorWorkoutDao;
    } else {
      synchronized(this) {
        if(_indoorWorkoutDao == null) {
          _indoorWorkoutDao = new IndoorWorkoutDao_Impl(this);
        }
        return _indoorWorkoutDao;
      }
    }
  }

  @Override
  public WorkoutTypeDao workoutTypeDao() {
    if (_workoutTypeDao != null) {
      return _workoutTypeDao;
    } else {
      synchronized(this) {
        if(_workoutTypeDao == null) {
          _workoutTypeDao = new WorkoutTypeDao_Impl(this);
        }
        return _workoutTypeDao;
      }
    }
  }

  @Override
  public IntervalDao intervalDao() {
    if (_intervalDao != null) {
      return _intervalDao;
    } else {
      synchronized(this) {
        if(_intervalDao == null) {
          _intervalDao = new IntervalDao_Impl(this);
        }
        return _intervalDao;
      }
    }
  }

  @Override
  public ExportTargetDao exportTargetDao() {
    if (_exportTargetDao != null) {
      return _exportTargetDao;
    } else {
      synchronized(this) {
        if(_exportTargetDao == null) {
          _exportTargetDao = new ExportTargetDao_Impl(this);
        }
        return _exportTargetDao;
      }
    }
  }
}
