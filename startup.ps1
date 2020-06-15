$command = "docker run -it -v $PSScriptRoot" + ":/repo -p 9000:9000 gitpitch/desktop:pro"
& $ENV:COMSPEC /d /c $command
