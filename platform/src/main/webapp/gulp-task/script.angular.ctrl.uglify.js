// for angular - controller uglify
// by kzy

var gulp, uglify, rename;

try {
	gulp = require('gulp');
	uglify = require('gulp-uglify');
	rename = require("gulp-rename");
} catch (e) {
	console.info(e)
}
var ctrlBuild = {
	srcPath: "assets/javascripts/",
	outPath: "assets/javascripts/ctrl",
	bulid: function() {
		if (rename) {
			gulp.src(this.srcPath + '/**.js')
				.pipe(uglify())
				.pipe(rename({
					suffix: ".min"
				}))
				.pipe(gulp.dest(this.outPath));
		}

	},
	task: "ctrl"
}

gulp.task('ctrl', function() {
	ctrlBuild.bulid();
});
module.exports = ctrlBuild;