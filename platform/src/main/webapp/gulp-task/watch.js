var gulp;

try {
	gulp = require('gulp');
} catch (e) {
	console.info(e);
}


var watch = {
	src: [	"assets/**/*.js", 
			"assets/**/*.css", 
			"assets/**/*.html", 
			"assets/**/*.png",
			"assets/**/*.gif",
			"assets/**/*.jpg"],
	dest: "assets/stylesheets",
	bulid: function() {
		if (rename) {
			gulp.src(this.src)
				.pipe(gulp.dest(this.dest));
		}

	},
	task: "less"
}
gulp.watch(watch.src,function(){
	console.info(arguments);
})

module.exports = watch;