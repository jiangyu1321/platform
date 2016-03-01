var gulp, less, minifyCSS, rename;

try {
	gulp = require('gulp');
	less = require('gulp-less')
	minifyCSS = require('gulp-minify-css');
	rename = require("gulp-rename");
} catch (e) {
	console.info(e)
}


var lessBuild = {
	lessPath: "assets/less/bootstrap.less",
	cssPath: "assets/stylesheets",
	bulid: function() {
		if (rename) {
			gulp.src(this.lessPath)
				.pipe(less())
				// .pipe(gulp.dest(this.cssPath))
				.pipe(minifyCSS())
				.pipe(rename({
					suffix: ".min"
				}))
				.pipe(gulp.dest(this.cssPath));
		}

	},
	task: "less"
}

gulp.task('less', function() {
	lessBuild.bulid();
});
module.exports = lessBuild;